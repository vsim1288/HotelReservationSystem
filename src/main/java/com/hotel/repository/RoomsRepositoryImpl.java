package com.hotel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hotel.entity.Rooms;

public class RoomsRepositoryImpl implements RoomsRepositoryCustom {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Rooms> findVacantRooms(String checkIn, String checkOut) {
		Query query = em.createNativeQuery(
				"select ro.*\r\n" + 
				"from Rooms ro\r\n" + 
				"where ro.room_id not in (\r\n" + 
				"select \r\n" + 
				"	r.room_id\r\n" + 
				"from rooms r, booking b\r\n" + 
				"where r.room_id = b.room_id\r\n" + 
				"	and b.end_date <= :checkIn\r\n" + 
				"    and b.start_date >= :checkOut\r\n" + 
				"    and (TIMESTAMPDIFF(DAY, b.start_date, :checkOut) * TIMESTAMPDIFF(DAY, :checkIn, b.end_date)) > 0);", Rooms.class);
		
		query.setParameter("checkIn", checkIn);
		query.setParameter("checkOut", checkOut);
		
		@SuppressWarnings("unchecked")
		List<Rooms> roomsList = query.getResultList();
		
		for(Rooms r: roomsList) {
			System.out.println(r.getRoomId());
		}
		
		return roomsList;
	}

}
