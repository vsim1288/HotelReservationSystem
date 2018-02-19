package com.hotel.builder.form;

import com.hotel.form.BookingForm;

public class BookingFormBuilder {
	private BookingForm bookingForm;
	
	public BookingFormBuilder() {
		bookingForm = new BookingForm();
	}
	
	public BookingFormBuilder checkIn(String checkIn) {
		bookingForm.setCheckIn(checkIn);
		return this;
	}
	
	public BookingFormBuilder checkOut(String checkOut) {
		bookingForm.setCheckOut(checkOut);
		return this;
	}
	
	public BookingFormBuilder people(String people) {
		bookingForm.setPeople(people);
		return this;
	}
}
