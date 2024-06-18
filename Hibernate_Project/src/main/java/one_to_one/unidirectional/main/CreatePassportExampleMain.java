package one_to_one.unidirectional.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_one.unidirectional.entity.Passport;
import utils.HibernateUtils;

public class CreatePassportExampleMain {
public static void main(String[] args) {
	try(
		SessionFactory factory = HibernateUtils.getSessionFactory();
			Session sessionRef = factory.openSession();
			
		){
		Passport p1 = new Passport("P123", "Priya Kore",LocalDate.of(2020,6,12));
		
		Passport p2 = new Passport("P456", "Mahi Kore",LocalDate.of(2029,12,12));
		
		Transaction tx = sessionRef.beginTransaction();
		
		sessionRef.persist(p1);
		sessionRef.persist(p2);
		tx.commit();
		System.out.println("Passport Created...");
	}catch(Exception e) {
		e.printStackTrace();
	}

   }
}
