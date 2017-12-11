package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Rooms;

public interface RoomsDao {
	public int save(Rooms rooms);
	public Rooms get(int id);
	public List<Rooms> getAll();
	public void update(int id, Rooms room);
	public void delete(int id);
}
