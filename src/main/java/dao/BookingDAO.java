package dao;

import java.util.List;

import entities.Booking;

public interface BookingDAO {
	public List<Booking> findAll();
	public Booking insertBooking(Booking Booking);
	public boolean updateBooking(Booking Booking);
	public boolean deleteBooking(Booking Booking);
}
