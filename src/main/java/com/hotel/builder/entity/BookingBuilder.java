package com.hotel.builder.entity;

import java.util.Date;

import com.hotel.entity.Booking;
import com.hotel.entity.Rooms;
import com.hotel.entity.Users;

public class BookingBuilder {
	private Booking booking;
	
	public BookingBuilder() {
		booking = new Booking();
	}
	
	public BookingBuilder bookingId(int bookingId) {
		booking.setBookingId(bookingId);
		return this;
	}
	
	public BookingBuilder endDate(Date endDate) {
		booking.setEndDate(endDate);
		return this;
	}
	
	public BookingBuilder startDate(Date startDate) {
		booking.setStartDate(startDate);
		return this;
	}
	
	public BookingBuilder roomId(Rooms roomId) {
		booking.setRoomId(roomId);
		return this;
	}
	
	public BookingBuilder username(Users username) {
		booking.setUsername(username);
		return this;
	}
	
	public Booking build() {
		return booking;
	}
}
