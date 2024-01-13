package com.example.util;

import com.example.dto.UserDTO;
import com.example.models.Userprofile;

public class EntityToDTO {

	public UserDTO convertUser(Userprofile user) {
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword());

		globalUserDTO.setId(user.getIduser());
		return globalUserDTO;

	}

}