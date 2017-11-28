package dao;

import java.util.Date;
import java.util.List;

import entities.Rooms;

public interface RoomsDAO {
	public List<Rooms> findAll();
	public List<Rooms> findVacantRooms(Date checkIn, Date checkOut);
	public Rooms insertRooms(Rooms Rooms);
	public boolean updateRooms(Rooms Rooms);
	public boolean deleteRooms(Rooms Rooms);
}
