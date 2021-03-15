package com.myapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myapp.dao.MemberDAO;
import com.myapp.vo.Member;

public class MemberLoginService {
	
	final String url = "jdbc:mysql://localhost:3306/stephy?allowPublicKeyRetrieval=true&useSSL=false";
	final String id = "root";
	final String pw = "2002";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, id, pw);
	}
	
	public Member login(Member member) throws Exception {
		MemberDAO dao = new MemberDAO();
		Connection conn = getConnection();
		
		return dao.login(conn, member);
	}
}
