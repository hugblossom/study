package com.myapp.web.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	static final String url = "jdbc:mysql://localhost:3306/stephy?serverTimezone=UTC&characterEncoding=UTF-8";
	static final String id = "root";
	static final String pw = "2002";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
}
