package com.app.models;

import javax.ejb.ApplicationException;

public class JsonError {
	private String error;
	
	public static JsonError create(String error) {
		JsonError je = new JsonError();
		je.setError(error);
		return je;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
