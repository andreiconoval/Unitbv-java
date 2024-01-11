package com.example;

import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class StatelessEjb
 */
@Stateless(mappedName = "StatelessEjb")
@LocalBean
public class StatelessEjb implements StatelessEjbRemote {

	@PersistenceContext
	private EntityManager entityManage;
    /**
     * Default constructor. 
     */
    public StatelessEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(String name) {
		entityManage.persist(new com.example.models.Userprofile(name));	
		
	}

	@Override
	public String sayHello() {
		return "EJB say hello0";
	}

}
