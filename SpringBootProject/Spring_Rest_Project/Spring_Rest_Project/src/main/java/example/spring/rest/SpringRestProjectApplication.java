//its not a predifined class
package example.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = { "movie_api","example"})
public class SpringRestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProjectApplication.class, args);
	}

}
