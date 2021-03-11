package com.myapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myapp.dao.MemberDAO;
import com.myapp.vo.Member;

public class MemberService {
	final String url = "jdbc:mysql://localhost:3306/stephy?allowPublicKeyRetrieval=true&useSSL=false";
	final String id = "root";
	final String pw = "2002";
	
	Connection conn = null;
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, id, pw);
	}
	
	MemberDAO dao = new MemberDAO();
	
	public boolean registMember(Member member)  {
		boolean result = false;
		
		
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false); // transaction 시작
			if ( dao.insert(conn, member) < 1 ) {
				throw new RuntimeException("맴버 삽입 실패");
			}
			
			if ( dao.addon(conn, member) < 1 ) {
				throw new RuntimeException("맴버addon 삽입 실패");
			}
			
			result = true;
			
			conn.commit();
		
		} catch ( Exception e ) {
			try {
				result = false;
				conn.rollback();
			} catch ( Exception e2 ) {
				
			}
		} finally {
			try {
				conn.close();
			} catch ( Exception e ) {
				
			}
		}
		
		return result;
	}
}
