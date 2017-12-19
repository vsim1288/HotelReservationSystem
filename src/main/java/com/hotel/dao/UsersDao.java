package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Users;

public interface UsersDao {
	public Users get(int id);
	public boolean save(Users users);
	public List<Users> getAll();
	public void update(int id, Users users);
	public void delete(int id);
	public String findByUserAndPassword(Users user);
}
