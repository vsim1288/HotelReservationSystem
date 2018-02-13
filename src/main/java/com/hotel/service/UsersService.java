package com.hotel.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hotel.entity.Users;

public interface UsersService {
	@Query("select u from users u where u.username = ?1")
	public Users findByUsername(String username);
	public Users get(Users user);
	public void saveUser(Users user);
	public List<Users> findAll();
}
