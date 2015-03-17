package com.nagarro.repository.user;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.user.User;
import com.nagarro.entity.user.UserRole;

/**
 * DAO for user roles.
 * @author ashish2069
 *
 */
@Repository
public class UserRolesDaoImpl implements UserRolesDao {
	/**
	 * Session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
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
	 * @see com.nagarro.repository.user.UserRolesDao#saveUserRole(java.lang.String, java.lang.String)
	 */
	public boolean saveUserRole (User user, String role) {
		boolean success = false;
		Session session = getSessionFactory().openSession();
		Transaction txn = null;
		try {
			txn = session.beginTransaction();
			
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			session.save(userRole);
			
			success = true;
			
			txn.commit();
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
}
