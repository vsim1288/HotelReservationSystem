package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.User;
import hibernate.HibernateConfig;

public class UserCRUD implements UserDAO {
	/**
	 * Checks if user exists in the database checking the username and password.
	 * 
	 * @return true if user found and validated
	 */
	public User findByUserAndPassword(User user) {
		System.out.println("usercrud");
		Session session = HibernateConfig.buildSessionFactory().openSession();
		System.out.println("findUser");
		try {
			session.beginTransaction();
			System.out.println("begin");
			User userFound = new User();

			if ((userFound = session.get(User.class, user.getUsername())) != null) {
				Hibernate.initialize(userFound.getRole());
				Hibernate.initialize(userFound.getUserInfo());
				Hibernate.initialize(userFound.getBookingRecords());

				if (user.getUsername().equals(userFound.getUsername())
						&& user.getPassword().equals(userFound.getPassword())) {
					System.out.println("found: " + userFound.getUsername() + ":" + userFound.getPassword() + ":"
							+ userFound.getRole().getRoleName());
					return userFound;
				}
			}

			session.getTransaction().commit();

			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("error: " + e.getMessage().toString());
			return null;
		} finally {
			System.out.println("close");
			session.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> findAll() {
		Session session = HibernateConfig.buildSessionFactory().openSession();
		List<User> userList;

		try {
			session.beginTransaction();

			Query query = session.createQuery("select u from User u");

			userList = query.getResultList();

			session.getTransaction().commit();
			System.out.println("userCRUD");
			return userList;
		} catch (Exception e) {
			System.out.println("FindALL ERROR: " + e.getMessage());

			session.getTransaction().rollback();

			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean insertUser(User user) {
		Session session = HibernateConfig.buildSessionFactory().openSession();

		try {
			session.beginTransaction();

			session.save(user);

			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();

			return false;
		} finally {
			session.close();
		}
	}

	/**
	 * Not implemented
	 */
	@Override
	public boolean updateUser(User user) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public boolean deleteUser(User user) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User findByUsername(String username) {
		Session session = HibernateConfig.buildSessionFactory().openSession();

		try {
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery("select u from User u where u.username = :username");
			query.setParameter("username", username);
			System.out.println(username);
			User user = query.getSingleResult();

			session.getTransaction().commit();

			if (user == null) {
				return null;
			}

			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());

			session.getTransaction().rollback();

			return null;
		}
	}
}
