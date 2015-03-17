package com.nagarro.repository.user;

import com.nagarro.entity.user.User;

/**
 * Interface for user roles data access object.
 * 
 * @author ashish2069
 *
 */
public interface UserRolesDao {

	/**
	 * Save user role details in the DB.
	 * 
	 * @param user - User name for which the role details need to be saved.
	 * @param role - Roel ID in the form of a string.
	 * @return - true if successful, else false.
	 */
	public abstract boolean saveUserRole(User user, String role);

}