package main.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordDeleteExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory sf = HibernateUtils.getSessionFactory()	;
				Session sessionRef = sf.openSession();
			){
				Class<Movie> entityType = Movie.class;
				Object identity = 102;//identity = new Integer(101)
				Movie foundMovie = sessionRef.find(entityType, identity);
				
				Transaction tx = sessionRef.beginTransaction();
				sessionRef.remove(foundMovie);
				tx.commit();
				System.out.println("Record deleted...");
				
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	}

