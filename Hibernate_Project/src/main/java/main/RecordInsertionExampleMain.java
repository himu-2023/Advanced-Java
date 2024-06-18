package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entertainment.entity.Movie;

public class RecordInsertionExampleMain {

	public static void main(String[] args) {
	//step 1
	Configuration hibernateConfig = new Configuration();
	hibernateConfig = hibernateConfig.configure();
	
	//step2
	SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
	
	//step 3
	 Session hibernateSession=hibernateFactory.openSession();
	 
	 //step 4-->DML operation we are insering record in table
	 Movie movieObj = new Movie(103, "Boys Over Flower", "Romantic", 2001);
	 
	 //step 5-->it will begin the transaction the this will give you 
	 Transaction hibernateTransaction = hibernateSession.beginTransaction();
	 
	 //step 6-->persisted means stored 
	 
	 hibernateSession.persist(movieObj);
	 
	 //step 7-->save the changes
	hibernateTransaction.commit();
	
	//step 8-->close the session
	hibernateSession.close();
	
	//step 9-->close sessionFactory
	hibernateFactory.close();
	
	System.out.println("Record inserted");
	
	}

}
