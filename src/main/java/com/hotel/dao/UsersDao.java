package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Users;

public interface UsersDao {
	public Users get(int id);
	public int save(Users room);
	public List<Users> getAll();
	public void update(int id, Users room);
	public void delete(int id);
}
