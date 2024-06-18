package one_to_many.ubidirectional.main;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_many.unidirectional.entity.CricketPlayer;
import one_to_many.unidirectional.entity.CricketTeam;
import utils.HibernateUtils;

public class LinkPlayersToTeamsExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){
			//Load all players
			Class<CricketPlayer> playerType = CricketPlayer.class;
			CricketPlayer player1 = sessionRef.find(playerType, 1);
			CricketPlayer player2 = sessionRef.find(playerType, 2);
			CricketPlayer player3 = sessionRef.find(playerType, 3);
			CricketPlayer player4= sessionRef.find(playerType, 4);
			CricketPlayer player5 = sessionRef.find(playerType,5);
			CricketPlayer player6 = sessionRef.find(playerType, 6);
			//load all teams
			Class<CricketTeam> teamType = CricketTeam.class;
			CricketTeam team1 = sessionRef.find( teamType, "IND");	
			CricketTeam team2 = sessionRef.find( teamType, "Aus");	
			//start transaction
			Transaction tx = sessionRef.beginTransaction();
			//Link players to team
			//populating a set of 3 players:player1,player2,player3
			Set<CricketPlayer> indianPlayers = 	Set.of(player1, player2, player3);
			team1.setPlayers(indianPlayers);
			//populating a set of 3 players:player4,player5,player6
			Set<CricketPlayer> australianPlayers = 	Set.of(player4, player5, player6);
			team2.setPlayers(australianPlayers);
			//commit transaction
			
			
			
			
			tx.commit();
			System.out.println("Linked created...");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
