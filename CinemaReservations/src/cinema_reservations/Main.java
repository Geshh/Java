package cinema_reservations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		MovieManager MM = new MovieManager(session);

		//Integer movieID1 = MM.addMovie("Silicon Vally", (float) 9.9);

		MM.listMovies();

		System.out.println();
		

		
		MM.listMovies();
		session.close();
		
//		LocalDate ld = LocalDate.of(1234, 5, 5);
//		System.out.println(ld.toString());
//
//		Time time = Time.valueOf("19:10:00");
//		System.out.println(time.toString());
			
		
	}
}
