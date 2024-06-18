package main.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordRetrievalExampleMain {

	public static void main(String[] args) {
		
	try(
			SessionFactory sf = HibernateUtils.getSessionFactory()	;
			Session sessionRef = sf.openSession();
		){
			Class<Movie> entityType = Movie.class;
			Object identity = 101;//identity = new Integer(101)
			Movie foundMovie = sessionRef.find(entityType, identity);
			if(foundMovie != null) {
				System.out.println(foundMovie);
				System.out.println("Movie Title : " +foundMovie.getTitle());
			}else
				System.out.println("Movie with given ID is not exists");
			//select * from movie_master_details where movie_id=?-->(?===101)
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}