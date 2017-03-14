package cinema_reservations;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectionManager {

	private Session session;

	public ProjectionManager(Session session) {
		this.session = session;
	}

	public Integer addProjection(int movie_id, String type, LocalDate date, String time) {

		Integer projectionID = null;

		Projection prj = new Projection(movie_id, type, date, time);
		projectionID = (Integer) session.save(prj);

		return projectionID;

	}

	public void listProjection() {

		List projections = session.createQuery("FROM Projection").getResultList();

		for (Iterator iterator = projections.iterator(); iterator.hasNext();) {

			Projection projection = (Projection) iterator.next();
			System.out.println("Movie_ID : " + projection.getMovie_id());
			System.out.println("Type : " + projection.getType());
			System.out.println("Date : " + projection.getDate());
			System.out.println("Time : " + projection.getTime());
		}

	}

	public void updateProjection(Integer prjID, String time) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Projection projection = (Projection) session.get(Projection.class, prjID);
			projection.setTime(time);
			session.update(projection);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
	}

	public void deleteProjection(Integer prjID) {
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Projection projection = (Projection) session.get(Projection.class, prjID);
			session.delete(projection);
			
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}

	}

}
