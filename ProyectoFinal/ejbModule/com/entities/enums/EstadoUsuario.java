package com.entities.enums;

import java.io.Serializable;

public enum EstadoUsuario implements Serializable {
	SIN_VALIDAR,
	VALIDADOS,
	ELIMINADO;
	
	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
}
