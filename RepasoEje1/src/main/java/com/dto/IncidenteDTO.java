package com.dto;

import java.io.Serializable;

public class IncidenteDTO implements Serializable {
	
	private String nombresYApellidos;
	private String descripcion;
	private String tipo;
	private String duracion;
	private String estado;
	
	public String getNombresYApellidos() {
		return nombresYApellidos;
	}
	public void setNombresYApellidos(String nombresYApellidos) {
		this.nombresYApellidos = nombresYApellidos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
