package com.hotel.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entity.Users;

@Repository
@Transactional
public class UsersDaoImp implements UsersDao {
	private SessionFactory sessionFactory;

	@Autowired
	public UsersDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Users get(int id) {
		return null;
	}

	@Transactional
	@Override
	public int save(Users room) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAll() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select u from Users u");
		
		return query.getResultList();
	}

	@Transactional
	@Override
	public void update(int id, Users room) {

	}

	@Transactional
	@Override
	public void delete(int id) {

	}

}
