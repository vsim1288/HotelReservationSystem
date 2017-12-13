package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Booking;
import com.hotel.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking/getAll")
	public ResponseEntity<List<Booking>> getAll() {
		List<Booking> bookingList = bookingService.getAll();
		return ResponseEntity.ok().body(bookingList);
	}
}
