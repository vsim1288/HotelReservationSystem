package service;

import java.util.List;

import entities.Photo;


public interface PhotoServiceInterface {
	public Photo save(Photo Photo);

	public Photo get(Photo Photo);

	public List<Photo> getAll();

	public boolean update(long id, Photo Photo);

	public boolean delete(long id);
}
