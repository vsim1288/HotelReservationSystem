package dao;

import java.util.Iterator;
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
	public boolean insertBooking(List<Booking> bookingList) {
		Session session = HibernateConfig.buildSessionFactory().openSession();
		System.out.println("insertbooking");
		try {
			session.beginTransaction();
			
			Iterator<Booking> it = bookingList.iterator();
			
			while(it.hasNext()) {
				session.save(it.next());
			}
			
			session.getTransaction().commit();
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
			session.getTransaction().rollback();
			
			return false;
		}
	}

	/**
	 * Not implemented
	 */
	@Override
	public boolean updateBooking(Booking Booking) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public boolean deleteBooking(Booking Booking) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Booking> findAll(String username) {
		Session session = HibernateConfig.buildSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			Query<Booking> query = session.createQuery("select b from Booking b where b.username = :username");
			query.setParameter("username", username);
			
			List<Booking> bookingList = query.getResultList();

			session.getTransaction().commit();
			
			return bookingList;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
			session.getTransaction().rollback();
			
			return null;
		}
	}

}
