package com.nagarro.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

/**
 * Bean for handling user information while registration.
 * @author ashish2069
 *
 */
@Component
public class UserBean {
	/**
	 * Username chosen at the time of registration (Unique for each user).
	 */
	@NotBlank
	@Pattern (regexp = "^[a-zA-Z0-9]*$")
	private String userName;
	
	/**
	 * PAssword corresponding to the username.
	 */
	@NotBlank
	@Pattern (regexp = "^[a-zA-Z0-9]*$")
	private String password;
	
	/**
	 * Email ID set by user at time of registration, used for retrieving account details.
	 */
	@NotBlank
	@Email
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
}
