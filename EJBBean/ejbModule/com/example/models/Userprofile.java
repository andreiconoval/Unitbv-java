package com.example.models;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the userprofile database table.
 * 
 */
@Entity
@NamedQuery(name="Userprofile.findAll", query="SELECT u FROM Userprofile u")
@NamedQuery(name = "findUserByUsername", query = "SELECT u FROM Userprofile u WHERE u.username = :username")
public class Userprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;

	private String name;

	private String password;

	private String username;

	public Userprofile() {
	}
	
	public Userprofile(String name) {
		this.name = name;
		this.password = name;
		this.username = name;
	}
	
	public Userprofile(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	
	public Userprofile(String username, String password, String name) {
		super();
		this.password = password;
		this.username = username;
		this.name = name;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}