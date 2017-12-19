package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Roles;

public interface RolesDao {
	public Roles get(String role);

	public int save(Roles role);

	public List<Roles> getAll();

	public void update(int id, Roles room);

	public void delete(int id);
}
