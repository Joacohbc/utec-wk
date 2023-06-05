package com.app;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.app.services.UserDAO;

@RequestScoped
@Path("/users")
@Produces({ "application/json" })
@Consumes({ "application/json" })
public class UserController {
	
	@EJB
	private UserDAO dao;
	
	@GET
	@Path("/{id}")
	public Response getUser(@PathParam("id") Long id) {
		return Response.ok(dao.getById(id)).build();
	}
}
