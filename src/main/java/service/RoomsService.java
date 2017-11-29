package service;

import java.util.Date;
import java.util.List;

import dao.RoomsCRUD;
import entities.Rooms;

public class RoomsService implements RoomsServiceInterfaces {
	RoomsCRUD roomsCRUD = new RoomsCRUD();
	
	/**
	 * Not implemented
	 */
	@Override
	public Rooms save(Rooms Rooms) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public Rooms get(Rooms Rooms) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Rooms> getVacantRooms(Date checkIn, Date checkOut) {
		System.out.println("roomservice");
		return roomsCRUD.findVacantRooms(checkIn, checkOut);
	}

	/**
	 * Not implemented
	 */
	@Override
	public List<Rooms> list() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public void update(long id, Rooms Rooms) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public void delete(long id) {
		throw new UnsupportedOperationException();
	}

}
