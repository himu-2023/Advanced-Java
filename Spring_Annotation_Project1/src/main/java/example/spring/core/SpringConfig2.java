package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfig2 {
//Declaring a Bean of type Address
	@Bean("addr")
	//@Primary //wired only this
	public Address getAddress() {
		Address myAddress = new Address("Chennai",421110);
		return myAddress;
	}
	
	@Bean("addr2")
	//@Primary //wired only this
	public Address getAddress2() {
		Address myAddress = new Address("Mumbai",411565);
		return myAddress;
	}
	
	//Declaring a Bean of Type Customer
	@Bean("cust")
	public Customer getCustomer() {
		//not setting permanentAddress
		//Asking spring to auto-wiring
		Customer customerRef = new Customer();
	
		customerRef.setCustomerId("C001");
		customerRef.setName("Nidhi Sharma");
		customerRef.setAge(48);
		return customerRef;
	}
}
