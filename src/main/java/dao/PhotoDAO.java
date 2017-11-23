package dao;

import java.util.List;

import entities.Photo;

public interface PhotoDAO {
	public List<Photo> findAll();
	public Photo findByPhotoName(Photo Photo);
	public Photo insertPhoto(Photo Photo);
	public boolean updatePhoto(Photo Photo);
	public boolean deletePhoto(Photo Photo);
}
