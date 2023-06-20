package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/patente")
public class TasaPatenteRest {
	
	@GET
	public String estimar(@QueryParam(value = "anio") Integer anio) {
		if(anio >= 2000) return "ALTA";
		if(2000 > anio && anio >= 1990) return "MEDIA";
		if(anio < 1990) return "EXENTA";
		return "";
	}
}
