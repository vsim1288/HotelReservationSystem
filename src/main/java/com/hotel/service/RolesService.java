package com.hotel.service;

import java.util.List;

import com.hotel.entity.Roles;

public interface RolesService {
	public Roles get(String role);
	public boolean save(Roles role);
	public List<Roles> getAll();
	public void update(int id, Roles role);
	public void delete(int id);
}
