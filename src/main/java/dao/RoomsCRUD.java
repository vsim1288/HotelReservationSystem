package dao;

import java.sql.Date;
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

	@Override
	public List<Rooms> findVacantRooms(Date checkIn, Date checkOut) {
		Session session = HibernateConfig.buildSessionFactory().openSession();

		try {
			session.beginTransaction();

			Query<?> query = session.createQuery(
					"select r.roomId, r.roomType, r.occupied from Rooms r, Booking b where r.roomId = b.roomId endDate >= :checkIn and startDate >= :checkOut");

			@SuppressWarnings("unchecked")
			List<Rooms> roomsList = (List<Rooms>) query.getResultList();

			return roomsList;
		} catch (Exception e) {
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
