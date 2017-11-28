package service;

import java.util.Date;
import java.util.List;

import dao.RoomsCRUD;
import entities.Rooms;

public class RoomsService implements RoomsServiceInterfaces {
	RoomsCRUD roomsCRUD = new RoomsCRUD();
	
	@Override
	public Rooms save(Rooms Rooms) {
		return null;
	}

	@Override
	public Rooms get(Rooms Rooms) {
		return null;
	}

	@Override
	public List<Rooms> getVacantRooms(Date checkIn, Date checkOut) {
		System.out.println("roomservice");
		return roomsCRUD.findVacantRooms(checkIn, checkOut);
	}

	@Override
	public List<Rooms> list() {
		return null;
	}

	@Override
	public void update(long id, Rooms Rooms) {
		
	}

	@Override
	public void delete(long id) {
		
	}

}
