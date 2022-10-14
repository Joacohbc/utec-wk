package com.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BeanLocal
 */

@Stateless
@LocalBean
public class BeanLocal {

    /**
     * Default constructor. 
     */
    public BeanLocal() {
    }
    
    public int CalcularLargo(String palabra) {
    	return palabra.length();
    }
}
