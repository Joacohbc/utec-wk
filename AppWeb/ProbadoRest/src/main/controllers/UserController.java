package controllers;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.models.JsonError;
import com.app.services.UserDAO;

import models.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
	
	@EJB
	private UserDAO db;
	
	@GET
	@Path("{userId}")
	public Response getUsers(@PathParam("userId") Long id) {
	 	User u = db.getById(id);
	 	if(u == null) {
	 		Response.status(404).entity(JsonError.create("A user with that ID does not exist")).build();
	 	}
		return Response.ok(u).build();
	}
	
	@GET
	public Response getUsers() {
		return Response.ok(db.getAll()).build();
	}
	
	@POST
	public Response newUser(@FormParam("name") String name, @FormParam("lastname") String lastname, @FormParam("age") Integer age) {
		User u = new User();
		u.setUsername(name);
		u.setLastname(lastname);
		u.setAge(age);
		Response.accepted(db.insert(u)).build();
	}
}
