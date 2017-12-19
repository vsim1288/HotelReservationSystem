package com.hotel.service;

import java.util.List;

import com.hotel.entity.Users;

public interface UsersService {
	public Users get(Users user);
	public boolean save(Users room);
	public List<Users> getAll();
	public void update(int id, Users room);
	public void delete(int id);
	public String findByUsername(Users user);
}
