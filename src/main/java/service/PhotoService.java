package service;

import java.util.List;

import dao.PhotoCRUD;
import entities.Photo;

public class PhotoService implements PhotoServiceInterface {
	PhotoCRUD photoCRUD = new PhotoCRUD();

	/**
	 * Not implemented
	 */
	@Override
	public Photo save(Photo Photo) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public Photo get(Photo Photo) {	
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Photo> getAll() {	
		return photoCRUD.findAll();
	}

	/**
	 * Not implemented
	 */
	@Override
	public boolean update(long id, Photo Photo) {	
		throw new UnsupportedOperationException();
	}

	/**
	 * Not implemented
	 */
	@Override
	public boolean delete(long id) {
		throw new UnsupportedOperationException();
	}

}
