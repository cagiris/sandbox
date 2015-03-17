package com.nagarro.entity.flight;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nagarro.repository.flight.Constants;

/**
 * Entity for database table for flight owners.
 * @author ashish2069
 *
 */
@Entity
@Table(name = Constants.FLIGHT_OWNER_TABLE)
public class FlightOwner {
	/**
	 * Flight owner's unique ID.
	 */
	@Id 
	@Column(name = Constants.FLIGHT_OWNER_ID)
	private int id;
	
	/**
	 * Flight owner's name.
	 */
	@Column(name = Constants.FLIGHT_OWNER_NAME)
	private String ownerName;

	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "flightOwner")
	private Set<FlightDetails> flightDetails;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the flightDetails
	 */
	public Set<FlightDetails> getFlightDetails() {
		return flightDetails;
	}

	/**
	 * @param flightDetails the flightDetails to set
	 */
	public void setFlightDetails(Set<FlightDetails> flightDetails) {
		this.flightDetails = flightDetails;
	}
}
