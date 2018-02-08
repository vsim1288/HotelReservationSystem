package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;
import com.hotel.repository.BookingRepository;

@Service
public class BookingServiceImp implements BookingService {
	@Autowired
	private BookingRepository bookingDao;
	
	@Override
	public Booking get(int id) {
		return null;
	}

	@Override
	public int save(Booking room) {
		return 0;
	}

	@Override
	public List<Booking> getAll() {
		return bookingDao.findAll();
	}

	@Override
	public void update(int id, Booking room) {
				
	}

	@Override
	public void delete(int id) {
		
	}
}
