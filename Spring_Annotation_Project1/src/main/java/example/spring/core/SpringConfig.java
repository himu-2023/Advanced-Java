package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration//marks this class as a configuration unit
public class SpringConfig {

	//this class is equivalent to spring-config.xml
	/*
	 * <beans>
	 * <bean id="getHelloBean" class="....HelloService"/>
	 * </beans>
	 */
	@Bean   //marks this method as a Bean Registration Method
	//the default ID is the method name:getHelloBean
	public GreetingService getHelloBean() {
		GreetingService gs = new HelloService();
		return gs;
	}
	@Bean("greet")//OverWrites the default ID 
	public GreetingService getWelcomeBean() {
		GreetingService gs = new WelcomeService();
		return gs;
	}
	@Bean
	@Lazy//mark this bean as lazy
	public GreetingService matchResult() {
		//this is equivalent of setter Injection
		CricketMatchResult result = new CricketMatchResult();
		result.setWinningTeam("India");
		result.setLosingTeam("Pakistan");
		result.setWinningMargin(6);
		result.setWinningType("Runs");
		return result;
	}
	@Bean
	@Scope("prototype")
	public GreetingService matchResult2() {
		//this is equivalent to constructor Injection
		GreetingService gs =  new CricketMatchResult(8, "India", "Ireland","Wickets");
		return gs;
	}
}
