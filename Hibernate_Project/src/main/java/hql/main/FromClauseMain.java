package hql.main;

import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entertainment.entity.annotations.Movie;
import one_to_many.unidirectional.entity.CricketTeam;
import utils.HibernateUtils;

public class FromClauseMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){
			
			String hqlQuery = "from Movie m";//m-->alias
			Class<Movie> movieType = Movie.class;
			Query<Movie> queryRef = sessionRef.createQuery(hqlQuery,movieType);
			List<Movie> movieList = queryRef.list();
			for (Movie currentMovie : movieList) 
				System.out.println(currentMovie);
				System.out.println("=========================================");
				
			for (Movie currentMovie : movieList) 
					System.out.println("Title :" + currentMovie.getTitle());
			
			
		}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
