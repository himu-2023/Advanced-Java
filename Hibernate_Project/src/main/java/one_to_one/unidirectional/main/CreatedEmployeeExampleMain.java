package one_to_one.unidirectional.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import one_to_one.unidirectional.entity.Employee;
import one_to_one.unidirectional.entity.Passport;
import utils.HibernateUtils;

public class CreatedEmployeeExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
					Session sessionRef = factory.openSession();
					
				){
			
			Employee e1 = new Employee(123, "Priya Kore", 5000, null);
		Employee e2 = new Employee(456, "Mahi Kore", 45000, null);
					
     Transaction tx = sessionRef.beginTransaction();
		
		sessionRef.persist(e1);
		sessionRef.persist(e2);
		tx.commit();
		System.out.println("Employee Created...");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
