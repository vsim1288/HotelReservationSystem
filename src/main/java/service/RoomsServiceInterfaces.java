package service;

import java.sql.Date;
import java.util.List;

import entities.Rooms;

public interface RoomsServiceInterfaces {
	public Rooms save(Rooms Rooms);

	public Rooms get(Rooms Rooms);
	
	public List<Rooms> list();

	public void update(long id, Rooms Rooms);

	public void delete(long id);

	List<Rooms> getVacantRooms(Date checkIn, Date checkOut);
}
