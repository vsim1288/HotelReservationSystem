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
	public Users get(int id) {
		return null;
	}

	@Override
	public int save(Users room) {
		return 0;
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

}
