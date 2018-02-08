package com.hotel.service;

import java.util.List;

import com.hotel.entity.Users;

public interface UsersService {
	public Users get(Users user);
	public void saveUser(Users user);
	public List<Users> findAll();
}
