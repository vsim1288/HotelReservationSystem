package service;

import java.util.List;

import dao.UserCRUD;
import entities.User;

public class UserService implements UserServiceInterface {
	private UserCRUD userCRUD = new UserCRUD();

	@Override
	public boolean save(User user) {
		if (userCRUD.findByUsername(user.getUsername()) != null) {
			return false;
		}

		return userCRUD.insertUser(user);
	}

	@Override
	public User get(User user) {
		return userCRUD.findByUserAndPassword(user);
	}

	@Override
	public List<User> list() {
		return userCRUD.findAll();
	}

	/**
	 * Not implemented
	 */
	@Override
	public void update(long id, User user) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public void delete(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getByUsername(String username) {
		return userCRUD.findByUsername(username);
	}

}
