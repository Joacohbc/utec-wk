package com.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "tasaPatente")
public class TasaPatente {
	
	@WebMethod
	public String estimar(Integer anio) {
		if(anio >= 2000) return "ALTA";
		if(2000 < anio && anio >= 1990) return "MEDIA";
		if(anio < 1990) return "EXENTA";
		return "";
	}
}
