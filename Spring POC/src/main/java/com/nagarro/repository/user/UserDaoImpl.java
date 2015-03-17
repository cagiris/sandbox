package com.nagarro.repository.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.user.InvalidUserDataException;
import com.nagarro.entity.user.User;

/**
 * Perform database CRUD operations for user table.
 * 
 * @author ashish2069
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	/**
	 * Session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserRolesDao userRolesDao;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.nagarro.repository.user.UserDao#findUser(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public User findUser (final String userName, final String password) {
		Session session = getSessionFactory().openSession();
		Transaction txn = null;
		User user = null;
		
		try {
			txn = session.beginTransaction();

			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq(Constants.USER_NAME, userName))
					.add(Restrictions.eq(Constants.USER_PASSWORD, password));

			List<User> users = criteria.list();
			if (!users.isEmpty()) {
				user = users.get(0);
			} else {
				throw new InvalidUserDataException(
						Constants.INVALID_USERDETAILS);
			}

			txn.commit();
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}

			e.printStackTrace();
		} finally {
			session.close();
		}

		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.nagarro.repository.user.UserDao#addNewUser(com.nagarro.entity.user.User)
	 */
	public boolean addNewUser (final User user) {
		boolean success = false;
		Session session = getSessionFactory().openSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(User.class)
								.add(Restrictions.eq(Constants.USER_EMAILID, user.getEmailId()));
			if (criteria.list().isEmpty()) {
				criteria = session.createCriteria(User.class)
						   .add(Restrictions.eq(Constants.USER_NAME, user.getUserName()));
				if (criteria.list().isEmpty()) {
					session.save(user);
					txn.commit();
					success = userRolesDao.saveUserRole(user, Constants.ROLE_USER);
				} else {
					throw new InvalidUserDataException(Constants.USERNAME_ALREADY_EXISTS);
				}
			} else {
				throw new InvalidUserDataException(Constants.EMAIL_ID_ALREADY_REGISTERED);
			}
			
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			
			e.printStackTrace();
			
			success = false;
		} finally {
			session.close();
		}
		
		return success;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.repository.user.UserDao#findUserUsingEmailId(java.lang.String)
	 */
	public User findUserUsingEmailId (final String emailID) {
		User user = null;
		
		Session session = getSessionFactory().openSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class)
								.add(Restrictions.eq(Constants.USER_EMAILID, emailID));
			if (criteria.list().isEmpty()) {
				throw new InvalidUserDataException(Constants.EMAIL_ID_NOT_REG);
			} else {
				user = (User) criteria.list().get(0);
			}
			
			txn.commit();
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return user;
	}

	/**
	 * @return the userRolesDao
	 */
	public UserRolesDao getUserRolesDao() {
		return userRolesDao;
	}

	/**
	 * @param userRolesDao the userRolesDao to set
	 */
	public void setUserRolesDao(UserRolesDao userRolesDao) {
		this.userRolesDao = userRolesDao;
	}
}
