package com.example.dao;

import jakarta.ejb.Remote;

@Remote
public interface UserRoleDAORemote {
		boolean IsUserAdmin(int userId);
}
