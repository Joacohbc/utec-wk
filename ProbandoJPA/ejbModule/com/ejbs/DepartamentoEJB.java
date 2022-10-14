package com.ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import com.entities.Departamento;

/**
 * Session Bean implementation class DepartamentoEJB
 */
@Singleton
@LocalBean
public class DepartamentoEJB implements DepartamentoEJBRemote {

	/**
	 * Default constructor.
	 */
	public DepartamentoEJB() {
	}

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProbandoJPA");

	@Override
	public void addDepartamento(Departamento dep) {
		EntityManager em = emf.createEntityManager();
		em.persist(dep);
		em.flush();
	}

	@Override
	public void removeDepartamento(Departamento dep) {
		EntityManager em = emf.createEntityManager();
		em.remove(dep);
		em.flush();
	}

	@Override
	public Departamento getDepartamento(Long id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Departamento.class, id);
	}

}
