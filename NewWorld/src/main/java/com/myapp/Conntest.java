package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conntest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stephy?&useSSL=false","root","2002");
			
			if ( conn != null ) {
				System.out.println("conn success");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
