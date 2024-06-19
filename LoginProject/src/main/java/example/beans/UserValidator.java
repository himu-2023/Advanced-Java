package example.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import example.utils.JDBCUtil;

public class UserValidator {
	public static boolean isValid(User currentUserRef) {
		boolean success = false;
		String sqlQuery = "select * from app_users where user_id = ? and user_pwd = ?";
		try (Connection dbConnection = JDBCUtil.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);

		) {
			String currentUserName = currentUserRef.getUserId();
			String currentUserPassword = currentUserRef.getPassword();

			pstmt.setString(1, currentUserName);
			pstmt.setString(2, currentUserPassword);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {// check if user is valid
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// code to interact with db and return boolean value
		return success;
	}
}
