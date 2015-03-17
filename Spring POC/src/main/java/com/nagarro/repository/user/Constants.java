package com.nagarro.repository.user;

/**
 * @author ashish2069
 * Constants required for Login
 */
public interface Constants {
	/**
	 * Table name for user.
	 */
	String USERS_TABLE = "users";
	
	// Various columns in the users table
	
	/**
	 * Table column name for user name.
	 */
	String USER_NAME = "userName";
	
	/**
	 * Table column name for user's password.
	 */
	String USER_PASSWORD = "password";
	
	/**
	 * Table column name for user's email-id.
	 */
	String USER_EMAILID = "emailId";
	
	/**
	 * Table column name for user's enabled flag.
	 */
	String USER_ENABLED = "enabled";
	
	/**
	 * Table name for user roles.
	 */
	String USER_ROLES_TABLE = "user_roles";
	
	// Various columns in the user roles table
	
	/**
	 * Unique ID for the role mapping.
	 */
	String USER_ROLES_ID = "id";
	
	/**
	 * user name for the attached role.
	 */
	String USER_ROLES_USERNAME = "userName";
	
	/**
	 * Role string.
	 */
	String USER_ROLES_ROLE = "role";
	
	
	// Query results
	
	/**
	 * Query result for invalid user name or password.
	 */
	String INVALID_USERDETAILS = "Invalid user name or password";

	/**
	 * Query result for an already registered e-mail ID.
	 */
	String EMAIL_ID_ALREADY_REGISTERED = "Email ID provided is already registered";

	/**
	 * Query result for an existing user name error.
	 */
	String USERNAME_ALREADY_EXISTS = "Username already taken";

	/**
	 * Query result for an unregistered email ID.
	 */
	String EMAIL_ID_NOT_REG = "This email ID is not registered";

	/**
	 * Query result for successful email of user account details.
	 */
	String USER_DETAILS_EMAILED = "User details have been mailed to the registered e-mail ID";

	/**
	 * Query result for successful log out action.
	 */
	String USER_LOGGED_OUT = "Log out successful";

	/**
	 * Query result for successul registration of new user.
	 */
	String NEW_USER_REGISTERED = "The new user details have been registered";
	
	// User validation results

	/**
	 * Validation Message for invalid email Id.
	 */
	String INVALID_EMAIL_ID = "Provided E-mail is not valid";

	/**
	 * Validation Message for empty email-id.
	 */
	String EMPTY_EMAIL_ID = "Email-ID can't be left empty";

	/**
	 * Validation Message for invalid user name.
	 */
	String INVALID_USER_NAME = "Provided user name is not valid (Only alpha numeric)";

	/**
	 * Validation Message for empty user name.
	 */
	String EMPTY_USER_NAME = "User name can't be left empty";

	/**
	 * Validation Message for invalid password.
	 */
	String INVALID_PASSWORD = "Provided password is not valid (Only alpha numeric)";

	/**
	 * Validation Message for empty password field.
	 */
	String EMPTY_PASSWORD = "Password can't be left empty";
	
	// Regex

	/**
	 * Regex expression for a valid email-id.
	 */
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	/**
	 * Regex expression for a valid password.
	 */
	String PASSWORD_REGEX = "^[a-zA-Z0-9]*$";

	/**
	 * Regex expression for a valid username.
	 */
	String USERNAME_REGEX = "^[a-zA-Z0-9]*$";
	
	// User roles.
	
	/**
	 * Normal user role.
	 */
	String ROLE_USER = "ROLE_USER";

	/**
	 * Admin user role.
	 */
	String ROLE_ADMIN = "ROLE_ADMIN";
}
