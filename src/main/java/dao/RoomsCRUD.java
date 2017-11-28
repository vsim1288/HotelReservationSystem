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
			Query<?> query = session.createSQLQuery(
					"select r.roomId, r.roomTypesId, r.occupied from Rooms r LEFT JOIN(select b.roomId from Booking b where b.endDate >= :checkIn AND b.startDate <= :checkOut AND (timestampdiff(day, b.startDate, :checkOut)*timestampdiff(day, :checkIn, b.endDate)) > 0) occupied ON r.roomID = occupied.RoomID where occupied.roomID IS NULL").addEntity(Rooms.class);
			query.setDate("checkIn", checkIn);
			query.setDate("checkOut", checkOut);
			
			System.out.println("getresult");
			@SuppressWarnings("unchecked")
			List<Rooms> roomsList = (List<Rooms>) query.getResultList();

			for (Rooms elem : roomsList) {
				System.out.println(elem.getRoomId());
			}

			return roomsList;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

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
