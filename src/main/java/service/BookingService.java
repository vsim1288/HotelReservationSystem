package service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dao.BookingCRUD;
import entities.Booking;
import entities.BookingCompositeKey;
import entities.Rooms;

public class BookingService implements BookingServiceInterface {
	BookingCRUD bookingCRUD = new BookingCRUD();

	@Override
	public boolean save(int numberOfPeople, int numberOfRooms, Date checkIn, Date checkOut,
			String username) {
		int ratio = (int) Math.ceil(numberOfRooms / numberOfPeople);
		RoomsService roomsService = new RoomsService();
		List<Rooms> roomsList = new LinkedList<>();
		List<Booking> bookingList = new LinkedList<>();

		System.out.println("get vacant rooms");
		roomsList = roomsService.getVacantRooms(checkIn, checkOut);

		System.out.println("start booking");
		while (numberOfPeople != 0) {
			Iterator<Rooms> it = roomsList.iterator();

			while (it.hasNext()) {
				Rooms rooms = it.next();

				if (rooms.getRoomType().getNumberOfBeds() <= ratio) {
					numberOfPeople -= ratio;

					Booking booking = new Booking();
					BookingCompositeKey bck = new BookingCompositeKey();
					bck.setStartDate(checkIn);
					booking.setRoomIdStartDate(bck);
					booking.setEndDate(checkOut);

					bookingList.add(booking);
				} else if (rooms.getRoomType().getNumberOfBeds() <= numberOfPeople) {
					numberOfPeople = 0;

					Booking booking = new Booking();
					BookingCompositeKey bck = new BookingCompositeKey();
					bck.setStartDate(checkIn);
					booking.setRoomIdStartDate(bck);
					booking.setEndDate(checkOut);

					bookingList.add(booking);
				}

				break;
			}
		}

		System.out.println("save into db bookings");
		return bookingCRUD.insertBooking(bookingList);
	}

	@Override
	public Booking get(Booking Booking) {
		return null;
	}

	@Override
	public List<Booking> getAll() {
		return bookingCRUD.findAll();
	}

	@Override
	public void update(long id, Booking Booking) {

	}

	@Override
	public void delete(long id) {

	}

}
