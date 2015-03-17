package com.nagarro.entity.user;

/**
 * Some invalid data for user has been entered.
 * 
 * @author ashish2069
 *
 */
public class InvalidUserDataException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg - The message containing information for the incorrect user data.
	 */
	public InvalidUserDataException (final String msg) {
		super(msg);
	}
}
