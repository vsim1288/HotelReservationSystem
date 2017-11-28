package service;

import java.util.List;

import entities.User;

public interface UserServiceInterface {
	public boolean save(User user);

	public User get(User user);
	
	public User getByUsername(String username);

	public List<User> list();

	public void update(long id, User user);

	public void delete(long id);
}
