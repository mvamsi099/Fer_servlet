package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getconnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get the connection object
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/fer_jdbc", "root", "root");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}

	public static void closeconnection(Connection connection) {
		try {

			// close the connection
			connection.close();
		} catch (SQLException e) {
              
			e.printStackTrace();
		}
		
		
	}
	
}