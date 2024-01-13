package com.example.dao;

import java.util.List;
import java.util.ArrayList;

import com.example.dto.ChangePasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.UserDTO;
import com.example.exception.ChangePasswordException;
import com.example.exception.LoginException;
import com.example.models.Userprofile;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;

import jakarta.ejb.*;
import jakarta.persistence.*;


/**
 * Session Bean implementation class UserDao
 */
@Stateless(mappedName = "UserDao")
@LocalBean
public class UserDao implements UserDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	public UserDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public UserDTO findById(int id) {
		Userprofile user = entityManager.find(Userprofile.class, id);
		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;
	}

	@Override
	public List<UserDTO> findAll() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<Userprofile> users = query.getResultList();
		System.out.println(users.toString());
		List<UserDTO> dtoUsers = new ArrayList<>();
		for (Userprofile user : users) {
			dtoUsers.add(entityToDTO.convertUser(user));
		}
		return dtoUsers;
	}

	@Override
	public UserDTO create(UserDTO userDTO) {
		Userprofile user = dtoToEntity.convertUser(userDTO);
		entityManager.persist(user);
		entityManager.flush();
		userDTO.setId(user.getIduser());
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		Userprofile user = dtoToEntity.convertUser(userDTO);
		user.setIduser(userDTO.getId());
		user = entityManager.merge(user);
		return userDTO;
	}

	@Override
	public void delete(int id) {
		Userprofile user = entityManager.find(Userprofile.class, id);
		entityManager.remove(user);

	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) throws LoginException {
		Userprofile user = null;
		try {
			user = entityManager.createNamedQuery("findUserByUsername", Userprofile.class)
					.setParameter("username", loginDTO.getUsername()).getSingleResult();
		} catch (NoResultException e) {
			throw new LoginException("Wrong authentication!");
		}
		if (!loginDTO.getPassword().equals(user.getPassword())) {
			throw new LoginException("Wrong authentication!");
		}

		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;

	}

	@Override
	public Boolean updatePassword(ChangePasswordDTO changePasswordDTO) throws ChangePasswordException {
		Userprofile user = null;
		try {
			user = entityManager.createNamedQuery("findUserByUsername", Userprofile.class)
					.setParameter("username", changePasswordDTO.getUsername()).getSingleResult();
			if (user.getPassword().equals(changePasswordDTO.getOldPassword())) {
				if (!changePasswordDTO.getOldPassword().equals(changePasswordDTO.getNewPassword())) {
					user.setPassword(changePasswordDTO.getNewPassword());
					user = entityManager.merge(user);
					return true;
				} else {
					throw new ChangePasswordException(
							"Please choose another new password, not the same as the old one!");
				}
			} else
				throw new ChangePasswordException("The old password is not valid.");
		} catch (NoResultException e) {
			throw new ChangePasswordException("The username is not valid!");
		}

	}

}
