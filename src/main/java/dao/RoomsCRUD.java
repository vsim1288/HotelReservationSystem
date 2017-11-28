package dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Rooms;
import hibernate.HibernateConfig;

public class RoomsCRUD implements RoomsDAO {

	@Override
	public List<Rooms> findAll() {
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Rooms> findVacantRooms(Date checkIn, Date checkOut) {
		Session session = HibernateConfig.buildSessionFactory().openSession();

		try {
			session.beginTransaction();

			System.out.println("prepare query");
			Query<?> query = session.createQuery(
					"select r.roomId, r.roomTypes, r.occupied from Rooms r, Booking b where r.roomId = b.roomId and endDate >= :checkIn and startDate >= :checkOut");
			query.setDate("checkIn", checkIn);
			query.setDate("checkOut", checkOut);
			System.out.println(query.toString());
			System.out.println("getresult");
			@SuppressWarnings("unchecked")
			List<Rooms> roomsList = (List<Rooms>) query.getResultList();

			return roomsList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			return new LinkedList<Rooms>();
		}
	}

	@Override
	public Rooms insertRooms(Rooms Rooms) {
		return null;
	}

	@Override
	public boolean updateRooms(Rooms Rooms) {
		return false;
	}

	@Override
	public boolean deleteRooms(Rooms Rooms) {
		return false;
	}

}
