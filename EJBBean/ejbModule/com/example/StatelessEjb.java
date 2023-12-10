package com.example;

import jakarta.ejb.*;

/**
 * Session Bean implementation class StatelessEjb
 */
@Stateless(mappedName = "StatelessEjb")
@LocalBean
public class StatelessEjb implements StatelessEjbRemote {

    /**
     * Default constructor. 
     */
    public StatelessEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sayHello() {
		return "EJB say hello0";
	}

}
