package com.example.dao;

import com.example.dto.ChangePasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RegisterDTO;
import com.example.dto.UserDTO;
import com.example.exception.ChangePasswordException;
import com.example.exception.LoginException;

import jakarta.ejb.Remote;

@Remote
public interface UserDAORemote extends GenericDAO<UserDTO> {

	UserDTO loginUser(LoginDTO loginDTO) throws LoginException;
	
	UserDTO registerUser(RegisterDTO registerDTO) throws LoginException;

	Boolean updatePassword(ChangePasswordDTO changePasswordDTO) throws ChangePasswordException;
}
