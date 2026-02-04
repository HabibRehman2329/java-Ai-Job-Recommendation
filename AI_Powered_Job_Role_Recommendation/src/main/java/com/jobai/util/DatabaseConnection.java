package com.jobai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// CHANGE THESE VALUES ACCORDING TO YOUR SYSTEM
	private static final String URL = "jdbc:mysql://localhost:3306/jobai_db?useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// Load MySQL Driver (old-style, stable)
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Loaded Successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load MySQL JDBC Driver");
			e.printStackTrace();
		}
	}

	// Get Connection Method
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
