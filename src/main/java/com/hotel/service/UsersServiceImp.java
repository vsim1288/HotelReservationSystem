package com.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		final Logger log = LoggerFactory.getLogger(UsersServiceImp.class);
		
		Users userSaved = new Users();
		
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setEnabled((byte)1);
		
		Roles role = roleRepository.findOne(1);
		
		log.info("Got role: " + role.getRoleName());
		
		users.setRoleId(role);		

		userSaved = userRepository.save(users);
		
		if(userSaved == null) {
			log.info("Failed saving user!");
		} else {
			log.info("User saved!");
		}
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
