package service;

import java.util.Date;
import java.util.List;

import entities.Booking;

public interface BookingServiceInterface {

	public Booking get(Booking Booking);

	public List<Booking> getAll();
	
	public List<Booking> getAll(String username);

	public void update(long id, Booking Booking);

	public void delete(long id);

	boolean save(int numberOfPeople, int numberOfRooms, Date checkIn, Date checkOut,
			String username);
}
