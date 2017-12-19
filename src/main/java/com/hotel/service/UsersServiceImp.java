package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.UsersDao;
import com.hotel.entity.Users;

@Service
public class UsersServiceImp implements UsersService {
	@Autowired
	private UsersDao usersDao;

	@Override
	public Users get(Users user) {
		return null;
	}

	@Override
	public boolean save(Users users) {
		return usersDao.save(users);
	}

	@Override
	public List<Users> getAll() {
		return usersDao.getAll();
	}

	@Override
	public void update(int id, Users room) {
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findByUsername(Users user) {
		return usersDao.findByUserAndPassword(user);
	}
}
