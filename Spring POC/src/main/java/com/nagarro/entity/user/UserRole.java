package com.nagarro.entity.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nagarro.repository.user.Constants;

/**
 * POJO class for mapping user roles.
 * @author ashish2069
 *
 */
@Entity
@Table(name = Constants.USER_ROLES_TABLE)
public class UserRole {

	/**
	 * Unique role ID.
	 */
	@Id
	@Column(name = Constants.USER_ROLES_ID)
	private int id;
	
	/**
	 * Username having this role.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = Constants.USER_ROLES_USERNAME)
	private User user;
	
	/**
	 * Role string.
	 */
	@Column(name = Constants.USER_ROLES_ROLE)
	private String role;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
