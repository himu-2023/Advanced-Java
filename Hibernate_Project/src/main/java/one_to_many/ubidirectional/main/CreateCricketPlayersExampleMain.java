package one_to_many.ubidirectional.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_many.unidirectional.entity.CricketPlayer;
import one_to_one.unidirectional.entity.Employee;
import utils.HibernateUtils;

public class CreateCricketPlayersExampleMain {

	public static void main(String[] args) {
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){
			CricketPlayer player1 = new CricketPlayer(1,"Virat Kohli",35);
			CricketPlayer player2 = new CricketPlayer(2,"Rohit Sharma",36);
			CricketPlayer player3 = new CricketPlayer(3,"Hardik Pandya",33);
			CricketPlayer player4 = new CricketPlayer(4,"Jaspreet Bumrah",28);
			CricketPlayer player5 = new CricketPlayer(5,"Ravindra Jadeja",37);
			CricketPlayer player6 = new CricketPlayer(6,"Shubhaman Gill",27);
			
			Transaction tx = sessionRef.beginTransaction();
			sessionRef.persist(player1);
			sessionRef.persist(player2);
			sessionRef.persist(player3);
			sessionRef.persist(player4);
			sessionRef.persist(player5);
			sessionRef.persist(player6);
			
			tx.commit();
			System.out.println("Players are created...");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
