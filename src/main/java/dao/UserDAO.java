package dao;

import java.util.List;

import entities.User;

public interface UserDAO {
	public List<User> findAll();
	public User findByUserAndPassword(User user);
	public User findByUsername(String username);
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}
