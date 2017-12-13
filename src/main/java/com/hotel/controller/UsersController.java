package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Users;
import com.hotel.service.UsersServiceImp;

@RestController
public class UsersController {
	@Autowired
	private UsersServiceImp usersService; 
	
	@GetMapping("users/getAll")
	private ResponseEntity<List<Users>> getAll() {
		List<Users> usersList = usersService.getAll();
		return ResponseEntity.ok().body(usersList);
	}
}
