package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","root123");
		System.out.println("Connection Created");
	}

}
