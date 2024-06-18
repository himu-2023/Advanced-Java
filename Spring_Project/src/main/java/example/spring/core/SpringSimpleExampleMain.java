package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSimpleExampleMain {

	public static void main(String[] args) {
		
		ApplicationContext context;
		//.means current project/path/xml file
		String configPath = "./src/main/resources/spring-config.xml";//this is not actual path this is  the relative path
		context = new FileSystemXmlApplicationContext(configPath);
		
		Object loadedObject = context.getBean("greet2");
		//loadedObject.sayGreeting();-->this will gives an error so will do typecast by interface
		GreetingService hs = (GreetingService)loadedObject;
		String reply = hs.sayGreeting();
		System.out.println(reply);
		
	}

}
