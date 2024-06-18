package example.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.spring.mvc.model.User;
import example.spring.mvc.model.UserValidator;

@Controller//this mark class as a controller
@SessionAttributes("validUser")
public class SpringMvcController {
	
	@RequestMapping ("/greet")//this  mark  the method as a RequestMapping
	public String getIndexPage() {
		System.out.println("Request Recieved");
		//this method invoked when client request for the resource with url: /greet
		return "index";
	}
	
	@RequestMapping("/showLogin")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/doValidate",method = RequestMethod.POST)
	public String doValidateUser(@RequestParam("user_name") String uid, @RequestParam("user_password") String pwd) {
		//String uid= request.getParameter("user_name");
		
		User userObj = new User(uid,pwd);
		Boolean valid = UserValidator.isValid(userObj);
		String resultPage = "failure";
		if(valid)
			resultPage = "success";
		
		System.out.println(uid+ "" +pwd);
		return resultPage;
	}
	
	@RequestMapping(value = "/doValidateAgain",method = RequestMethod.POST)
	public String doValidateUserAgain(@RequestParam("user_name") String uid, @RequestParam("user_password") String pwd,Model dataModel) {
		//String uid= request.getParameter("user_name");
		
		User userObj = new User(uid,pwd);
		Boolean valid = UserValidator.isValid(userObj);
		String resultPage = "failureAgain";
		if(valid)
			resultPage = "successAgain";
		dataModel.addAttribute("validUser",uid);
		
		
		return resultPage;
	}
}


