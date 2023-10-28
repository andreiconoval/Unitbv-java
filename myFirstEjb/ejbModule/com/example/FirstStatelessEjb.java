package com.example;

import com.example.model.User;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

/**
 * Session Bean implementation class FirstStatelessEjb
 */
@Stateless
@LocalBean
public class FirstStatelessEjb implements FirstStatelessEjbRemote {

	@PersistenceContext
	private EntityManager entityManage;
	
    /**
     * Default constructor. 
     */
    public FirstStatelessEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(String name) {
		entityManage.persist(new User(name));	
	}

}