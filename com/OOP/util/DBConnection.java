package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/employee";
	private static String userName = "root";
	private static String password = "kavindu";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,userName,password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	


}
