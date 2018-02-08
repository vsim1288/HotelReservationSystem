package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.entity.Roles;
import com.hotel.entity.Users;
import com.hotel.repository.RolesRepository;
import com.hotel.repository.UserRepository;

@Service("userService")
public class UsersServiceImp implements UsersService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users get(Users user) {
		return null;
	}

	@Override
	public void saveUser(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setEnabled((byte)1);
		
		Roles role = roleRepository.findOne(1L);
		
		users.setRoleId(role);
		
		userRepository.save(users);
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
}
