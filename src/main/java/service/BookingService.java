package service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dao.BookingCRUD;
import entities.Booking;
import entities.BookingCompositeKey;
import entities.Rooms;
import entities.User;

public class BookingService implements BookingServiceInterface {
	BookingCRUD bookingCRUD = new BookingCRUD();

	@Override
	public boolean save(int numberOfPeople, int numberOfRooms, Date checkIn, Date checkOut, String username) {
		int ratio = (int) Math.ceil(numberOfRooms / numberOfPeople);
		RoomsService roomsService = new RoomsService();
		List<Rooms> roomsList = new LinkedList<>();
		List<Booking> bookingList = new LinkedList<>();
		UserService userService = new UserService();
		User user = userService.getByUsername(username);

		System.out.println("get vacant rooms, ratio: " + ratio);
		roomsList = roomsService.getVacantRooms(checkIn, checkOut);

		if (roomsList.size() < ratio + numberOfRooms - 1) {
			return false;
		}

		if (roomsList.isEmpty()) {
			return false;
		}

		System.out.println("start booking");
		try {
			Iterator<Rooms> it = roomsList.iterator();

			System.out.println("People: " + numberOfPeople);

			while (it.hasNext()) {
				Rooms rooms = it.next();
				System.out.println(rooms);

				if (rooms.getRoomType().getNumberOfBeds() <= ratio) {
					numberOfPeople -= ratio;

					Booking booking = new Booking();
					BookingCompositeKey bck = new BookingCompositeKey();
					bck.setRoomId(rooms.getRoomId());
					bck.setStartDate(checkIn);
					booking.setRoomIdStartDate(bck);
					booking.setEndDate(checkOut);
					booking.setUsername(user);

					System.out.println("1booking added");

					bookingList.add(booking);
				} else if (rooms.getRoomType().getNumberOfBeds() >= numberOfPeople) {
					numberOfPeople = 0;

					Booking booking = new Booking();
					BookingCompositeKey bck = new BookingCompositeKey();
					bck.setRoomId(rooms.getRoomId());
					bck.setStartDate(checkIn);
					booking.setRoomIdStartDate(bck);
					booking.setEndDate(checkOut);
					booking.setUsername(user);

					System.out.println("2booking added");

					bookingList.add(booking);

					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (numberOfPeople != 0) {
			return false;
		}

		System.out.println("booking complete");

		System.out.println("save into db bookings");
		return bookingCRUD.insertBooking(bookingList);
	}

	/**
	 * Not implemented
	 */
	@Override
	public Booking get(Booking Booking) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Booking> getAll() {
		return bookingCRUD.findAll();
	}

	/**
	 * Not implemented
	 */
	@Override
	public void update(long id, Booking Booking) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public void delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Booking> getAll(String username) {
		return bookingCRUD.findAll(username);
	}

}
