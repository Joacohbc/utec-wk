package com.cliente;

public class Main {

	public static void main(String[] args) {
		TasaPatente_Service patenteService = new TasaPatente_Service();
		TasaPatente patente = patenteService.getTasaPatentePort();
		System.out.println(patente.estimar(2000));
	}

}
