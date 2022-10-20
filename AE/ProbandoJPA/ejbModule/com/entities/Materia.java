package com.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Materia
 *
 */
@Entity
public class Materia implements Serializable {

	private static final long serialVersionUID = 1L;

	public Materia() {
		super();
	}

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	///
	// Getters y Setters
	//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
