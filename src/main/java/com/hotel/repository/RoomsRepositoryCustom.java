package com.hotel.repository;

import java.util.List;

import com.hotel.entity.Rooms;

public interface RoomsRepositoryCustom {
	List<Rooms> findVacantRooms(String checkIn, String checkOut);
}
