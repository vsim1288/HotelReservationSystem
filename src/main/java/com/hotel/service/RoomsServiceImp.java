package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Rooms;
import com.hotel.repository.RoomsRepository;

@Service
public class RoomsServiceImp implements RoomsService {
	
	@Autowired
	private RoomsRepository roomsDaoImp;
	
	@Override
	public Rooms get(int id) {
		return null;
	}

	@Override
	public void save(Rooms room) {
		roomsDaoImp.save(room);
	}

	@Override
	public List<Rooms> findAll() {
		return roomsDaoImp.findAll();
	}

	@Override
	public void update(int id, Rooms room) {

	}

	@Override
	public void delete(int id) {

	}

}
