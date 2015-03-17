package com.nagarro.repository.flight;

/**
 * @author ashish2069
 * Constants required for Login
 */
public interface Constants {
	/**
	 * Table name for flight owners.
	 */
	String FLIGHT_OWNER_TABLE = "flight_owners";
	
	// Various columns in the flight owner table
	/**
	 * Table column name for flight owner id.
	 */
	String FLIGHT_OWNER_ID = "id";
	
	/**
	 * Table column name for flight owner's name.
	 */
	String FLIGHT_OWNER_NAME = "ownerName";
	
	/**
	 * Table name for flight details.
	 */
	String FLIGHT_DETAILS_TABLE = "flight_details";
	
	// Various columns in the flight details table
	/**
	 * Table column name for flight number.
	 */
	String FLIGHT_DETAIL_NUMBER = "flightNumber";
	
	/**
	 * Table column name for flight owner's id.
	 */
	String FLIGHT_DETAIL_OWNER = "flightOwnerID";
	
	/**
	 * Table column for departure location code.
	 */
	String FLIGHT_DETAIL_DEPARTURE_LOC_CODE = "departureLocationCode";
	
	/**
	 * Table column for arrival location code.
	 */
	String FLIGHT_DETAIL_ARRIVAL_LOC_CODE = "arrivalLocationCode";
	
	/**
	 * Table column for last flight date.
	 */
	String FLIGHT_DETAIL_LAST_VALID_DATE = "lastValidDate";
	
	/**
	 * Table column for departure time.
	 */
	String FLIGHT_DETAIL_DEPARTURE_TIME = "departureTime";
	
	/**
	 * Table column for flight duration.
	 */
	String FLIGHT_DETAIL_DURATION = "durationInMinutes";
	
	/**
	 * Table column for flight's fare.
	 */
	String FLIGHT_DETAIL_FARE = "fare";
	
	/**
	 * Table column for seat availabity.
	 */
	String FLIGHT_DETAIL_SEAT_AVAILABILITY = "isSeatAvailable";
	
	/**
	 * Table column for flight class.
	 */
	String FLIGHT_DETAIL_CLASS = "flightClass";
}
