package service;

import java.util.List;

import dao.PhotoCRUD;
import entities.Photo;

public class PhotoService implements PhotoServiceInterface {
	PhotoCRUD photoCRUD = new PhotoCRUD();

	@Override
	public Photo save(Photo Photo) {
		return null;
	}

	@Override
	public Photo get(Photo Photo) {	
		return null;
	}

	@Override
	public List<Photo> getAll() {	
		return photoCRUD.findAll();
	}

	@Override
	public void update(long id, Photo Photo) {	
	}

	@Override
	public void delete(long id) {
	}

}
