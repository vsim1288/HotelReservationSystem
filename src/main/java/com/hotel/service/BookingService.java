package com.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;

@Service
public interface BookingService {
	public Booking get(int id);

	public int save(Booking room);

	public List<Booking> getAll();

	public void update(int id, Booking room);

	public void delete(int id);
}
