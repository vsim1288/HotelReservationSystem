package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Booking;
import hibernate.HibernateConfig;

public class BookingCRUD implements BookingDAO{

	@Override
	public List<Booking> findAll() {
		Session session = HibernateConfig.buildSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			Query<?> query = session.createQuery("from Booking");
			
			@SuppressWarnings("unchecked")
			List<Booking> bookingList = (List<Booking>) query.getResultList();
			
			return bookingList;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Booking insertBooking(Booking Booking) {
		return null;
	}

	@Override
	public boolean updateBooking(Booking Booking) {
		return false;
	}

	@Override
	public boolean deleteBooking(Booking Booking) {
		return false;
	}

}
