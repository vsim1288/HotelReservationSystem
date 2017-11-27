package service;

import java.sql.Date;
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
