package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Rooms;
import com.hotel.repository.RoomsRepository;

@Service("roomsService")
public class RoomsServiceImp implements RoomsService {
	
	@Autowired
	private RoomsRepository roomsRepository;
	
	@Override
	public Rooms get(int id) {
		return null;
	}

	@Override
	public void save(Rooms room) {
		roomsRepository.save(room);
	}

	@Override
	public List<Rooms> findAll() {
		return roomsRepository.findAll();
	}

	@Override
	public void update(int id, Rooms room) {

	}

	@Override
	public void delete(int id) {

	}
	
	public List<Rooms> findVacantRooms(String checkIn, String checkOut) {
		return roomsRepository.findVacantRooms(checkIn, checkOut);
	}
}
