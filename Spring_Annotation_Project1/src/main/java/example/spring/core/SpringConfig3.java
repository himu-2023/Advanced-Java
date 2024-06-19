package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan//Asking spring to scan the components
@ComponentScan(basePackages = {"juices","milkshakes","desserts","example"})
public class SpringConfig3 {
//@Bean methods if any
//	@Bean
//	public MyComponent getMyComponent() {
//		return new MyComponent();
//	}
}
