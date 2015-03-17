package com.nagarro.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Search parameters to be entered by the user.
 * @author ashish2069
 *
 */
public class SearchParametersBean {

	/**
	 * Departure location code.
	 */
	@NotBlank
	private String departureLocationCode;
	
	/**
	 * Arrival location code.
	 */
	@NotBlank
	private String arrivalLocationCode;
	
	/**
	 * Flight date.
	 */
	@Pattern (regexp = "^\\d\\d-\\d\\d-\\d\\d\\d\\d$")
	private String flightDate;

	/**
	 * Flight class.
	 */
	@NotBlank
	private String flightClass;

	/**
	 * @return the departureLocationCode
	 */
	public String getDepartureLocationCode() {
		return departureLocationCode;
	}

	/**
	 * @param departureLocationCode the departureLocationCode to set
	 */
	public void setDepartureLocationCode(String departureLocationCode) {
		this.departureLocationCode = departureLocationCode;
	}

	/**
	 * @return the arrivalLocationCode
	 */
	public String getArrivalLocationCode() {
		return arrivalLocationCode;
	}

	/**
	 * @param arrivalLocationCode the arrivalLocationCode to set
	 */
	public void setArrivalLocationCode(String arrivalLocationCode) {
		this.arrivalLocationCode = arrivalLocationCode;
	}

	/**
	 * @return the flightDate
	 * @throws ParseException 
	 */
	public Date getFlightDateFormatted() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		return dateFormat.parse(getFlightDate());
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * @return the flightDate
	 */
	public String getFlightDate() {
		return flightDate;
	}

	/**
	 * @param flightDate the flightDate to set
	 */
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
}
