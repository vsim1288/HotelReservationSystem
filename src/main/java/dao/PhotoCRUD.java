package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Photo;
import hibernate.HibernateConfig;

public class PhotoCRUD implements PhotoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> findAll() {
		List<Photo> photoList;
		Session session = HibernateConfig.buildSessionFactory().openSession();
		try {
			session.beginTransaction();
			
			Query<Photo> query = session.createQuery("from Photo");
			photoList = query.getResultList();
			
			System.out.println(photoList.size());
			
			session.getTransaction().commit();
			
			return photoList;
		} catch(Exception e) {
			session.getTransaction().rollback();
			
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Photo findByPhotoName(Photo Photo) {
		
		return null;
	}

	@Override
	public Photo insertPhoto(Photo Photo) {
		
		return null;
	}

	@Override
	public boolean updatePhoto(Photo Photo) {

		return false;
	}

	@Override
	public boolean deletePhoto(Photo Photo) {

		return false;
	}

}
