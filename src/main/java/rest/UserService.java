package rest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserService {
	EntityManager em = null;
	
	public boolean findUser(String username, String password) {
		Query query = em.createQuery("from User u where u.username = :username");
		query.setParameter("username", username);
		
		int user = query.getFirstResult();
		
		return (user > 0)?true:false;
	}
}
