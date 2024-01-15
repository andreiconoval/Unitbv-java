package com.example.dao;


import com.example.models.UserRole;

import jakarta.ejb.*;
import jakarta.persistence.*;

/**
 * Session Bean implementation class UserDao
 */
@Stateless(mappedName = "UserRoleDao")
@LocalBean
public class UserRoleDao implements UserRoleDAORemote {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean IsUserAdmin(int userId) {
        Query query = entityManager.createNamedQuery(UserRole.HAS_ROLE_QUERY);
        query.setParameter("userId", Integer.toString(userId));
        query.setParameter("role", "admin");

        long count = (long) query.getSingleResult();
        return count > 0;
	    
	}

}
	