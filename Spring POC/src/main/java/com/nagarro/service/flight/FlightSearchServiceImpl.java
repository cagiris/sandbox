package com.nagarro.service.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.flight.FlightDetails;
import com.nagarro.repository.flight.FlightsDao;

/**
 * Search the flights using the criteria entered by user.
 * 
 * @author ashish2069
 *
 */
@Service
public class FlightSearchServiceImpl implements FlightsSearchService {

	/**
	 * Flights data access object.
	 */
	@Autowired
	private FlightsDao flightsDao;
	
	/* (non-Javadoc)
	 * @see com.nagarro.service.flight.FlightsSearchService#findFlights(com.nagarro.entity.flight.SearchParameters)
	 */
	public List<FlightDetails> findFlights(com.nagarro.bean.SearchParametersBean searchParameters) {
		return flightsDao.findFlights(searchParameters);
	}

	/**
	 * @return the flightsDao
	 */
	public FlightsDao getFlightsDao() {
		return flightsDao;
	}

	/**
	 * @param flightsDao the flightsDao to set
	 */
	public void setFlightsDao(FlightsDao flightsDao) {
		this.flightsDao = flightsDao;
	}
}
