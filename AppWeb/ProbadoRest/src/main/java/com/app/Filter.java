package com.app;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class Filter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
		System.out.println("Hola: " + req.getUriInfo());
	}

	@Override
	public void filter(ContainerRequestContext req) throws IOException {
		System.out.println("Hola: " + req.getUriInfo());
	}

}
