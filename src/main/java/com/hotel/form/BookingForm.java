package com.hotel.form;

import org.hibernate.validator.constraints.NotEmpty;

public class BookingForm {
	@NotEmpty(message = "Please select a check-in date!")
	private String checkIn;

	@NotEmpty(message = "Please select a check-out date!")
	private String checkOut;

	@NotEmpty(message = "Please select the number of people!")
	private String people;

	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn
	 *            the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public String getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut
	 *            the checkOut to set
	 */
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the people
	 */
	public String getPeople() {
		return people;
	}

	/**
	 * @param people
	 *            the people to set
	 */
	public void setPeople(String people) {
		this.people = people;
	}	
}
