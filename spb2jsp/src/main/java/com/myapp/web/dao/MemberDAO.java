package com.myapp.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myapp.web.domain.Member;

@Repository
public class MemberDAO {

	public int selectCount(Connection conn) {
		
		int result = 0;
		
		try {
			
			String sql = "SELECT COUNT(*) AS cnt FROM t_member";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			result = rs.getInt("cnt");
			
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}
	
	public List<Member> selectAll(Connection conn) {
		
		List<Member> memberList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT * FROM t_member";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				memberList.add(
					Member.builder().uid(rs.getInt("uid")).id(rs.getString("id")).email(rs.getString("email")).build()
				);
			}
			
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
		
		return memberList;
	}

}
