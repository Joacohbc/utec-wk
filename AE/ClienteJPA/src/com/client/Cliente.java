package com.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejbs.DepartamentoEJBRemote;
import com.entities.Departamento;

public class Cliente {

	public static void main(String[] args) throws NamingException {
		DepartamentoEJBRemote der = InitialContext.doLookup("ProbandoJPA/DepartamentoEJB!com.ejbs.DepartamentoEJBRemote");
		
		Departamento dep = new Departamento();
		dep.setNombre("Dep. Matematicas");
		der.addDepartamento(dep);
		
		Departamento dep1 = new Departamento();
		dep1.setNombre("Dep. Fisica");
		der.addDepartamento(dep1);
		
		Departamento dep2 = new Departamento();
		dep2.setNombre("Dep. Mecanica");
		der.addDepartamento(dep2);
		
		System.out.println(der.getDepartamento(1l));
		System.out.println(der.getDepartamento(2l));
		System.out.println(der.getDepartamento(3l));
	}

}
