package com.nagarro.service.flight;

import java.util.List;

import com.nagarro.entity.flight.FlightDetails;

/**
 * Interface for flight serach service.
 * 
 * @author ashish2069
 *
 */
public interface FlightsSearchService {

	/**
	 * Find the flights using the criteria submitted by the user.
	 * 
	 * @param searchParameters - Search parameters inputed by user.
	 * @return the list of flights found.
	 */
	public abstract List<FlightDetails> findFlights(
			com.nagarro.bean.SearchParametersBean searchParameters);

}