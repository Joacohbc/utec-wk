package com.app.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.app.models.User;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public User insert(User u) {
		em.persist(u);
		em.flush();
		return u;
	}
	
	public List<User> getAll() {
		return em.createQuery("SELECT u FROM User", User.class).getResultList();
	}
	
	public User getById(Long id) {
		return em.find(User.class, id);
	}
}
