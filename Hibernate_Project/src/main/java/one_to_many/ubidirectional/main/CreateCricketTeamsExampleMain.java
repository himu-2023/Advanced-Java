package one_to_many.ubidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_many.unidirectional.entity.CricketPlayer;
import one_to_many.unidirectional.entity.CricketTeam;
import utils.HibernateUtils;

public class CreateCricketTeamsExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){
			CricketTeam teamIndia = new CricketTeam("IND", "India", null);
			CricketTeam teamAustralia = new CricketTeam("Aus", "Australia", null);
			
			
			Transaction tx = sessionRef.beginTransaction();
			sessionRef.persist(teamIndia);
			sessionRef.persist(teamAustralia);
			
			
			tx.commit();
			System.out.println("Teams created...");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
