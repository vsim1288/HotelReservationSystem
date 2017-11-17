package rest;

import java.util.List;

import org.hibernate.Session;
import hibernate.HibernateConfig;
import interfaces.UserDAO;
import model.User;

public class UserService implements UserDAO {
	/**
	 * Checks if user exists in the database checking the username and password.
	 * 
	 * @return true if user found and validated
	 */
	public boolean findByUser(User user) {
		Session session = HibernateConfig.buildSessionFactory().openSession();
		System.out.println("findUser");
		try {
			session.beginTransaction();
			System.out.println("begin");
			User userFound = new User();
			if ((userFound = session.get(User.class, user.getUsername())) != null) {
				if (user.getUsername().equals(userFound.getUsername())
						&& user.getPassword().equals(userFound.getPassword())) {
					System.out.println("found: " + userFound.getUsername() + ":" + userFound.getPassword());
					return true;
				}
			}

			session.getTransaction().commit();

			return false;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("error: " + e.getMessage().toString());
			return false;
		} finally {
			System.out.println("close");
			session.close();
		}
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		return false;
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
