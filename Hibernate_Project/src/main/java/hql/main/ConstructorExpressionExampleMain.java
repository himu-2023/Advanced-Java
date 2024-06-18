package hql.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import entertainment.bean.MovieData;
import utils.HibernateUtils;

public class ConstructorExpressionExampleMain {


	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){

			String hqlQuery = "select new entertainment.bean.MovieData( m.title,m.year) from Movie m";//m-->alias
			Query<MovieData> queryRef = sessionRef.createQuery(hqlQuery,MovieData.class);
			List<MovieData> movieDataList = queryRef.list();
			for (MovieData data : movieDataList) {
				System.out.println(data);
			}
			
			
		}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
