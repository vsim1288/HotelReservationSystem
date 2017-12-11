package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.dao.RoomsDao;
import com.hotel.entity.Rooms;

@Service
public class RoomsServiceImp implements RoomsService {
	
	@Autowired
	private RoomsDao roomsDaoImp;
	
	@Override
	public Rooms get(int id) {
		return null;
	}

	@Override
	public int save(Rooms room) {
		return roomsDaoImp.save(room);
	}

	@Override
	public List<Rooms> getAll() {
		return roomsDaoImp.getAll();
	}

	@Override
	public void update(int id, Rooms room) {
		roomsDaoImp.update(id, room);
	}

	@Override
	public void delete(int id) {
		roomsDaoImp.delete(id);
	}

}
