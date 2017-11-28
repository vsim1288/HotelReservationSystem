package service;

import java.util.List;

import dao.UserCRUD;
import entities.User;

public class UserService implements UserServiceInterface {
	private UserCRUD userCRUD = new UserCRUD();

	@Override
	public boolean save(User user) {
		System.out.println("userService");
				
		if(userCRUD.findByUsername(user.getUsername()) != null) {
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

	@Override
	public void update(long id, User user) {
		
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public User getByUsername(String username) {
		return userCRUD.findByUsername(username);
	}

}
