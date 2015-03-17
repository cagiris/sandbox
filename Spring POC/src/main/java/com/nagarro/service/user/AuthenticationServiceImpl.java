package com.nagarro.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.user.User;
import com.nagarro.repository.user.UserDao;

/**
 * Hanle register/verification of user details.
 * 
 * @author ashish2069
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	/**
	 * User data access object.
	 */
	@Autowired
	private UserDao userDAO;
	
	/* (non-Javadoc)
	 * @see com.nagarro.service.user.Authentication#findUser(java.lang.String, java.lang.String)
	 */
	public User findUser (final String userName, final String password) {
		return userDAO.findUser(userName, password);
	}

	/* (non-Javadoc)
	 * @see com.nagarro.service.user.Authentication#addNewUser(com.nagarro.entity.user.User)
	 */
	public boolean addNewUser (final User user) {
		return userDAO.addNewUser(user);
	}

	/* (non-Javadoc)
	 * @see com.nagarro.service.user.Authentication#findUserUsingEmailId(java.lang.String)
	 */
	public User findUserUsingEmailId (final String emailID) {
		return userDAO.findUserUsingEmailId(emailID);
	}

	/**
	 * @return the userDAO
	 */
	public UserDao getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(final UserDao userDAO) {
		this.userDAO = userDAO;
	}
}
