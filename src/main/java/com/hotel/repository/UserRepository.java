package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Users;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}
