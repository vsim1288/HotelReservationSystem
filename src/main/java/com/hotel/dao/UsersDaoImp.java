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
	@Autowired
	private SessionFactory sessionFactory;

	public UsersDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Checks if user exists in the database checking the username and password.
	 * 
	 * @return true if user found and validated
	 */
	public String findByUserAndPassword(Users user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Users userFound = new Users();

			if ((userFound = session.get(Users.class, user.getUsername())) != null) {
				// Hibernate.initialize(userFound.getRole());
				// Hibernate.initialize(userFound.getUserInfo());
				// Hibernate.initialize(userFound.getBookingRecords());

				if (user.getUsername().equals(userFound.getUsername())
						&& user.getPassword().equals(userFound.getPassword())) {
					return "found";
				}
			}

			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("error: " + e.getMessage().toString());
			return "error";
		} finally {
			System.out.println("close");
			session.close();
		}
	}

	@Override
	public Users get(int id) {
		return null;
	}

	@Transactional
	@Override
	public boolean save(Users users) {
		return false;
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
