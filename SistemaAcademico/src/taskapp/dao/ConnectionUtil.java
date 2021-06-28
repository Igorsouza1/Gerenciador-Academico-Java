package taskapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/academicodb";
		String username = "root";
		String password = "";
		
		Connection conect = DriverManager.getConnection(dbURL, username, password);
		return conect;
	}
}
