package com.entities.enums;

import java.io.Serializable;

public enum Departamento implements Serializable {
	MONTEVIDEO("Montevideo"),
	CANELONES("Canelones"),
	MALDONADO("Maldonado"),
	SAN_JOSE("San José"),
	COLONIA("Colinia"),
	ROCHA("Rocha"),
	FLORIDA("Florida"),
	LAVALLEJA("Lavalleja"),
	FLORES("Flores"),
	SORIANO("Soriano"),
	TREINTA_Y_TRES("Treina y tres"),
	DURAZNO("Durazno"),
	RIO_NEGRO("Río Negro"),
	CERRO_LARGO("Cerro largo"),
	TACUAREMBO("Tacuarembó"),
	PAYSANDU("Paysandú"),
	RIVERA("Rivera"),
	SALTO("Salto"),
	ARTIGAS("Artigas");
	
	private String nombre;
	
	@Override
	public String toString() {
		return nombre;
	}
	
	private Departamento(String nombre) {
		this.nombre= nombre;
	}
	
}
