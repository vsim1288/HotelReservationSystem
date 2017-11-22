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
				
				if (user.getUsername().equals(userFound.getUsername())
						&& user.getPassword().equals(userFound.getPassword())) {
					System.out.println("found: " + userFound.getUsername() + ":" + userFound.getPassword() + ":" + userFound.getRole().getRoleName());
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
			
			Query query = session.createQuery("from users");
			
			userList = query.getResultList();
			
			session.getTransaction().commit();
			
			return userList;
		} catch(Exception e) {
			session.getTransaction().rollback();
			
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public User insertUser(User user) {
		Session session = HibernateConfig.buildSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
			
			return user;
		} catch(Exception e) {
			session.getTransaction().rollback();
			
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateUser(User user) {
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		return false;
	}
}
