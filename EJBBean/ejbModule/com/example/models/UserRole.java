package com.example.models;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
@NamedQuery(name = "UserRole.hasRole", query = "SELECT COUNT(u) FROM UserRole u WHERE u.userid = :userId AND u.role = :role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
    public static final String HAS_ROLE_QUERY = "UserRole.hasRole";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String role;

	private String userid;

	public UserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}