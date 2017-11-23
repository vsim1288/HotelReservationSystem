package service;

import java.util.List;

import entities.Photo;


public interface PhotoServiceInterface {
	public Photo save(Photo Photo);

	public Photo get(Photo Photo);

	public List<Photo> getAll();

	public void update(long id, Photo Photo);

	public void delete(long id);
}
