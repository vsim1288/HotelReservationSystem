package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	public static SessionFactory buildSessionFactory() {
			return new Configuration().configure().buildSessionFactory();
	}
}
