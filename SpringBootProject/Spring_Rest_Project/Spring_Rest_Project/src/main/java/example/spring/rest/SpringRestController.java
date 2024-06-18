package example.spring.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//marks this class as a REST controller
public class SpringRestController {
	@RequestMapping("/doGreet")
	public String sayGreeting() {
		return "Hello All,Spring REST welcomes you!!.";
	}
	@RequestMapping("/one-person")
	public Person getOnePerson() {
		Person personObj = new Person("Priya", "Narkhede", 29, "SoftwareDevoloper");
		return personObj;
	}
	@RequestMapping("/all-persons")
	public Collection<Person> getAllPersons() {
		Person personObj1 = new Person("Priya", "Narkhede", 29, "SoftwareDevoloper");
		
		Person personObj2 = new Person("Mahi", "Kore", 26, "Accountant");
		
		Person personObj3 = new Person("Dhiraj", "Narkhede", 32, "ProductionEngineer");
		List<Person> allPersons =List.of(personObj1,personObj2,personObj3 );
		return allPersons;
		
	}
}
