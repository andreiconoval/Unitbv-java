package com.example.util;

import com.example.dto.UserDTO;
import com.example.models.Userprofile;

public class DtoToEntity {
	
	public Userprofile convertUser(UserDTO userDTO) {
		Userprofile user = new Userprofile(userDTO.getUsername(), userDTO.getPassword());

		return user;
	}
}
