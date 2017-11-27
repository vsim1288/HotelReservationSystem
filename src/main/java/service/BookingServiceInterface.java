package service;

import java.sql.Date;
import java.util.List;

import entities.Booking;

public interface BookingServiceInterface {

	public Booking get(Booking Booking);

	public List<Booking> getAll();

	public void update(long id, Booking Booking);

	public void delete(long id);

	List<Booking> save(Booking Booking, int numberOfPeople, int numberOfRooms, Date checkIn, Date checkOut);
}
