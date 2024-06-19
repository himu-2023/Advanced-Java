package example.servlet;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this methods get invoked when client makes a request
		//generate HTML responce
		response.setContentType("text/html");//MIME Type-Multipurpose Internet Mail Enter
		PrintWriter out = response.getWriter();
		String responceText = "<h1 style = 'background-color:blue;color:yellow'>Welcome from Servlet</h1>";
		System.out.println(responceText);
	}

}
