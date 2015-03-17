package com.nagarro.entity.flight;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.nagarro.repository.flight.Constants;

/**
 * Entity class for database table for flight details.
 * @author ashish2069
 *
 */
@Entity
@Table(name = Constants.FLIGHT_DETAILS_TABLE)
public class FlightDetails {
	/**
	 * Flight number also acts as the unique key for this table.
	 */
	@Id
	@Column(name = Constants.FLIGHT_DETAIL_NUMBER)
	private String flightNumber;
	
	/**
	 * Flight owner.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = Constants.FLIGHT_DETAIL_OWNER)
	private FlightOwner flightOwner;
	
	/**
	 * Departure location code.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_DEPARTURE_LOC_CODE)
	private String departureLocationCode;
	
	/**
	 * Arrival location code.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_ARRIVAL_LOC_CODE)
	private String arrivalLocationCode;
	
	/**
	 * Last valid date for flight data.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_LAST_VALID_DATE)
	private Date lastValidDate;
	
	/**
	 * Departure time.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_DEPARTURE_TIME)
	private int departureTime;
	
	/**
	 * Duration of journey.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_DURATION)
	private int durationInMinutes;
	
	/**
	 * Fligh fare.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_FARE)
	private float fare;
	
	/**
	 * Are seats available or not.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_SEAT_AVAILABILITY)
	private boolean isSeatAvailable;
	
	/**
	 * Flight class E/B/EB.
	 */
	@Column(name = Constants.FLIGHT_DETAIL_CLASS)
	private String flightClass;

	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the flightOwner
	 */
	public FlightOwner getFlightOwner() {
		return flightOwner;
	}

	/**
	 * @param flightOwner the flightOwner to set
	 */
	public void setFlightOwner(FlightOwner flightOwner) {
		this.flightOwner = flightOwner;
	}

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
	 * @return the lastValidDate
	 */
	public Date getLastValidDate() {
		return lastValidDate;
	}

	/**
	 * @param lastValidDate the lastValidDate to set
	 */
	public void setLastValidDate(Date lastValidDate) {
		this.lastValidDate = lastValidDate;
	}

	/**
	 * @return the departureTime
	 */
	public int getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the durationInMinutes
	 */
	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	/**
	 * @param durationInMinutes the durationInMinutes to set
	 */
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	/**
	 * @return the fare
	 */
	public float getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(float fare) {
		this.fare = fare;
	}

	/**
	 * @return the isSeatAvailable
	 */
	public boolean getIsSeatAvailable() {
		return isSeatAvailable;
	}

	/**
	 * @param isSeatAvailable the isSeatAvailable to set
	 */
	public void setIsSeatAvailable(boolean isSeatAvailable) {
		this.isSeatAvailable = isSeatAvailable;
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
}
