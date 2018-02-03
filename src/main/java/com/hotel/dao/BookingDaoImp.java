package com.hotel.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entity.Booking;

@Repository
@Transactional
public class BookingDaoImp implements BookingDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Booking get(int id) {
		return null;
	}

	@Transactional
	@Override
	public int save(Booking booking) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getAll() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = (Query) session.createQuery("select b from Booking b");
		
		return query.getResultList();
	}

	@Transactional
	@Override
	public void update(int id, Booking booking) {
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		
	}

}
