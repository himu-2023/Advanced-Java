package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.beans.User;
import example.beans.UserValidator;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(urlPatterns = {"/doLogin"},name= "myLoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Logged IN: ").append(request.getContextPath());
	
	String userName = request.getParameter("user_name");
	String userPassword = request.getParameter("user_password");
	//System.out.println(userName+ " - " +userPassword);
	//populating user object based on userName and userPassword
	User currentUser = new User(userName,userPassword);
	//System.out.println(currentUser);
	//passing this user object to user validator for checking 
	boolean valid = UserValidator.isValid(currentUser);
	//System.out.println("Validation status: " +valid);
	//prepare for sending responce
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String responceText = "<h1 style = 'color:red'>Sorry, Authentication Failed</h1>";
	if(valid)
		responceText = 
		"<h1 style = 'color:green'>Congratulation, You are In</h1>";
	out.print(responceText);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
