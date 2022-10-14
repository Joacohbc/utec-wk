package com.ejbs;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;

@Remote
public interface DepartamentoEJBRemote {
	void addDepartamento(Departamento dep);
	void removeDepartamento(Departamento dep);
	Departamento getDepartamento(Long id);
}
