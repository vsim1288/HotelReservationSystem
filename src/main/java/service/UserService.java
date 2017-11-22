package service;

import java.util.List;

import dao.UserCRUD;
import entities.User;

public class UserService implements UserServiceInterface {
	private UserCRUD userCRUD = new UserCRUD();

	@Override
	public User save(User user) {
		return userCRUD.insertUser(user);
	}

	@Override
	public User get(User user) {
		return userCRUD.findByUserAndPassword(user);
	}

	@Override
	public List<User> list() {
		return null;
	}

	@Override
	public void update(long id, User user) {
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
