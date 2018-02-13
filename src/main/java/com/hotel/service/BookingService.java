package com.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;

@Service
public interface BookingService {
	public void saveBooking(String checkIn, String checkOut, String people, String username);
	public List<Booking> findAll();
}
