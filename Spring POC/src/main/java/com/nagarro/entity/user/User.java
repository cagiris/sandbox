package com.nagarro.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nagarro.repository.user.Constants;

/**
 * POJO class for user entity.
 * 
 * @author ashish2069
 *
 */
@Entity
@Table(name = Constants.USERS_TABLE)
public class User implements Serializable {
	/**
	 * Generated serial version.
	 */
	private static final long serialVersionUID = -3322933578051984995L;

	/**
	 * Username chosen at the time of registration (Unique for each user).
	 */
	@Id
	@Column(name = Constants.USER_NAME)
	private String userName;
	
	/**
	 * PAssword corresponding to the username.
	 */
	@Column(name = Constants.USER_PASSWORD)
	private String password;
	
	/**
	 * Email ID set by user at time of registration, used for retrieving account details.
	 */
	@Column(name = Constants.USER_EMAILID)
	private String emailId;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * Validate the username.
	 */
	public void validateUserName() {
		if ((userName != null) && userName.matches(Constants.PASSWORD_REGEX)) {
			if (userName.length() == 0) {
				throw new InvalidUserDataException(Constants.EMPTY_USER_NAME);
			}
		} else {
			throw new InvalidUserDataException(Constants.INVALID_USER_NAME);
		}
	}
	
	/**
	 * Validate the password.
	 */
	public void validatePassword() {
		if ((password != null) && password.matches(Constants.PASSWORD_REGEX)) {
			if (password.length() == 0) {
				throw new InvalidUserDataException(Constants.EMPTY_PASSWORD);
			}
		} else {
			throw new InvalidUserDataException(Constants.INVALID_PASSWORD);
		}
	}

	/**
	 * Validate the email-id.
	 */
	public void validateEmailId() {
		if ((emailId != null) && !emailId.matches(Constants.EMAIL_REGEX)) {
			if (emailId.length() == 0) {
				throw new InvalidUserDataException(Constants.EMPTY_EMAIL_ID);
			} else {
				throw new InvalidUserDataException(Constants.INVALID_EMAIL_ID);
			}
		}
	}
}
