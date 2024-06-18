package hql.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class SelectClauseExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){
			
			String hqlQuery = "select m.title,m.year from Movie m";//m-->alias
			Query<Object[]> queryRef = sessionRef.createQuery(hqlQuery,Object[].class);
			List<Object[]> movieInfoList = queryRef.list();
			for (Object[] movieInfo : movieInfoList) {
			   Object title = movieInfo[0];
			   Object year = movieInfo[1];
			   System.out.println("Movie : " + title + " was releted to " + year );
			}
			
			
			
		}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
