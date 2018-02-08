package com.hotel.service;

import java.util.List;

import com.hotel.entity.Rooms;

public interface RoomsService {
	public Rooms get(int id);
	public void save(Rooms room);
	public List<Rooms> findAll();
	public void update(int id, Rooms room);
	public void delete(int id);
}
