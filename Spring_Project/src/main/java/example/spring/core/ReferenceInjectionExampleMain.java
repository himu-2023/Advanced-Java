package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReferenceInjectionExampleMain {

	public static void main(String[] args) {
		

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config2.xml");
		
		Object loadedObject = context.getBean("currentCustomer");
		//Customer customerObject =(Customer)loadedObject;
		System.out.println(loadedObject);
	}

	
}
