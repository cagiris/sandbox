package com.nagarro.repository.flight;

import java.util.List;

import com.nagarro.entity.flight.FlightDetails;

/**
 * Interface for flight details data access object.
 * 
 * @author ashish2069
 *
 */
public interface FlightsDao {

	/**
	 * Find the flights using the criteria submitted by the user.
	 * 
	 * @param searchParameters - Search parameters inputed by user.
	 * @return the list of flights found.
	 */
	public abstract List<FlightDetails> findFlights(
			com.nagarro.bean.SearchParametersBean searchParameters);

}