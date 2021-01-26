package com.myapp.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myapp.vo.Member;

public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public boolean insert(String id, String pw, String email) throws SQLException, IOException {
		
		boolean flag = false;
		String sql = "INSERT INTO t_member(id, passwd, email) VALUES (?, ?, ?)";
		
		try {
			
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:myapp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			int result = pstmt.executeUpdate();
			
			if ( result > 0 ) {
				flag = true;
			}
			
		} finally {
			
			conn.close();
			
		}
		
		return flag;
				
	}
	
	public Member login(String id, String passwd) throws SQLException, IOException {
		
		String sql = "SELECT * FROM t_member WHERE id = ? AND passwd = ?";
		Member member = new Member();
		
		try {
			
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:myapp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				member.setIdx(rs.getInt("idx"));
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passWd"));
				member.setEmail(rs.getString("email"));
			}
			
		} finally {
			
			conn.close();
			
		}
		
		return member;
		
	}
	
}
