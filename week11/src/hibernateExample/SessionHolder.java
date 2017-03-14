package hibernateExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHolder {

	private static Session session;

	public static Session getInstance() {
		if (session != null) {
			SessionFactory factory = new Configuration().configure("/resources/hibernate.cfg.xml")
					.buildSessionFactory();
			session = factory.openSession();
		}
		return session;
	}

	public static void closeSession() {
		session.close();
	}

}
