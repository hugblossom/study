package com.myapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.myapp.dao.MemberDAO;
import com.myapp.vo.Member;

public class MemberSelectService {
	Connection conn	= null;
	MemberDAO dao	= new MemberDAO();
	
	public MemberSelectService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stephy?&useSSL=false", "root", "2002");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public Member getMember(String mem_id) throws SQLException {
		
		return dao.selectById(conn, mem_id);
		
	}
	
	public List<Member> getMemberList() throws SQLException {
		
		return dao.selectList(conn);
	}
}
