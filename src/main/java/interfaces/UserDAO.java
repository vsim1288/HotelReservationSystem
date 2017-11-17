package interfaces;

import java.util.List;

import model.User;

public interface UserDAO {
	public List<User> findAll();
	public boolean findByUser(User user);
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}
