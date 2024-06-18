package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLoadingExampleMain {
 public static void main(String[] args) {
	 ApplicationContext context = 
			 new ClassPathXmlApplicationContext("spring-config3.xml");//here for eager loading-->client don't need to make request
	 
	 context.getBean("myBean2");//client make a request for lazy loading
 
 }
}
