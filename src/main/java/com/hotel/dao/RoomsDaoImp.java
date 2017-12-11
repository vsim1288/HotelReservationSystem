package com.hotel.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entity.Rooms;

@Repository
@Transactional
public class RoomsDaoImp implements RoomsDao {
	private SessionFactory sessionFactory;
	
	@Autowired
	public RoomsDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public int save(Rooms rooms) {
		sessionFactory.getCurrentSession().save(rooms);
		return rooms.getRoomId();
	}

	@Override
	public Rooms get(int id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rooms> getAll() {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("select r from Rooms r");

		return query.getResultList();
	}

	@Transactional
	@Override
	public void update(int id, Rooms room) {
		Session session = sessionFactory.getCurrentSession();
		Rooms rooms = session.byId(Rooms.class).load(id);
		rooms.setRoomTypes(room.getRoomTypes());
		rooms.setOccupied(room.getOccupied());
		session.flush();
	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Rooms rooms = session.byId(Rooms.class).load(id);
		session.delete(rooms);
	}

}
