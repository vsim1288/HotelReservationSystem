package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.entity.Rooms;
import com.hotel.service.RoomsService;

@RestController
public class RoomsController {

	@Autowired
	private RoomsService roomsServiceImp;

	@GetMapping("/room/getAll")
	public ResponseEntity<List<Rooms>> getAll() {
		List<Rooms> rooms = roomsServiceImp.findAll();
		return ResponseEntity.ok().body(rooms);
	}

	@PostMapping("/room/addRoom")
	public ResponseEntity<?> save(@RequestBody Rooms rooms) {
		roomsServiceImp.save(rooms);

		return ResponseEntity.ok().body("New room has been saved!");
	}
	
	@PutMapping("/room/updateRoom/{id}")
	public ResponseEntity<?> save(@PathVariable("id") int id, @RequestBody Rooms rooms) {
		roomsServiceImp.update(id, rooms);

		return ResponseEntity.ok().body("Room has been succesfully updated!");
	}
	
	@DeleteMapping("/room/deleteRoom/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		roomsServiceImp.delete(id);

		return ResponseEntity.ok().body("Room has been succesfully deleted!");
	}

	
}
