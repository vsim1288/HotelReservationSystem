package com.hotel.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Booking;
import com.hotel.entity.Rooms;
import com.hotel.entity.Users;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.RoomsRepository;
import com.hotel.repository.UserRepository;

@Service
public class BookingServiceImp implements BookingService {
	@Autowired
	private BookingRepository bookingDao;

	@Autowired
	private UserRepository userDao;

	@Autowired
	private RoomsRepository roomsRepository;

	@SuppressWarnings("unused")
	@Override
	public void saveBooking(String checkIn, String checkOut, String people, String username) {
		final Logger log = LoggerFactory.getLogger(BookingServiceImp.class);
		Date checkInDate = null, checkOutDate = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		
		try {
			checkInDate = format.parse(checkIn);
			checkOutDate = format.parse(checkOut);
		} catch (ParseException e) {
			e.printStackTrace();
		}


		int nrOfPeople = Integer.parseInt(people);
		
		Booking booking = new Booking();

		List<Rooms> roomsList = new LinkedList<>();
		List<Booking> bookingList = new LinkedList<>();

		log.info("Getting user by username...");

		Users user = userDao.findByUsername(username);

		if (user == null) {
			log.error("Failed to get user!");

			return;
		}

		log.info("Got user successfuly!" + user);

		log.info("Getting rooms list...");

		roomsList = roomsRepository.findVacantRooms(checkIn, checkOut);
		
		booking.setRoomId(roomsList.get(0));
		booking.setStartDate(checkInDate);
		booking.setEndDate(checkOutDate);
		booking.setUsername(user);
		
		bookingDao.save(booking);
	}

	@Override
	public List<Booking> findAll() {
		return bookingDao.findAll();
	}

}
