package com.nagarro.service.user;

import com.nagarro.entity.user.User;

/**
 * Interface for user authentication service.
 * 
 * @author ashish2069
 *
 */
public interface AuthenticationService {

	/**
	 * Check if the provided user details are valid for a login.
	 * 
	 * @param userName - User name.
	 * @param password - Corresponding password.
	 * @return - The user object filled after fetching data from DB.
	 */
	public abstract User findUser(String userName, String password);

	/**
	 * Add a new user for the application.
	 * 
	 * @param user - Details of the user to be added to DB.
	 * @return true if the new user was added successfuly else false.
	 */
	public abstract boolean addNewUser(User user);

	/**
	 * Use the provided email ID to find a registered user.
	 * 
	 * @param emailID - Email ID of the registered user.
	 * @return the user corresponding to a registered email id.
	 */
	public abstract User findUserUsingEmailId(String emailID);

}