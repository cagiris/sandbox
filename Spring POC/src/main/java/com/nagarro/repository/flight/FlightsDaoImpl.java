package com.nagarro.repository.flight;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.flight.FlightDetails;

/**
 * Flights DAO.
 * 
 * @author ashish2069
 *
 */
@Repository
public class FlightsDaoImpl implements FlightsDao {
	/**
	 * Session factory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.nagarro.repository.flight.FlightsDao#getSessionFactory()
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.repository.flight.FlightsDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.nagarro.repository.flight.FlightsDao#findFlights(com.nagarro.entity.flight.SearchParameters)
	 */
	@SuppressWarnings("unchecked")
	public List<FlightDetails> findFlights(final com.nagarro.bean.SearchParametersBean searchParameters) {
		List<FlightDetails> flightsFound = new ArrayList<FlightDetails>();
		Session session = getSessionFactory().openSession();
		Transaction txn = null;
		
		try {
			txn = session.beginTransaction();

			Criteria criteria = session.createCriteria(FlightDetails.class)
								.add(Restrictions.eq(Constants.FLIGHT_DETAIL_DEPARTURE_LOC_CODE, searchParameters.getDepartureLocationCode()))
								.add(Restrictions.eq(Constants.FLIGHT_DETAIL_ARRIVAL_LOC_CODE, searchParameters.getArrivalLocationCode()))
								.add(Restrictions.eq(Constants.FLIGHT_DETAIL_CLASS, searchParameters.getFlightClass()))
								.add(Restrictions.ge(Constants.FLIGHT_DETAIL_LAST_VALID_DATE, searchParameters.getFlightDateFormatted()));

			flightsFound = criteria.list();
			
			txn.commit();
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}

			e.printStackTrace();
		} catch (ParseException e) {
			if (txn != null) {
				txn.rollback();
			}

			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return flightsFound;
	}
}
