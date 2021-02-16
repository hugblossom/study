package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.myapp.vo.Member;

public class Application {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM t_member WHERE mem_id = ?";
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stephy?&useSSL=false","root","2002");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "stephy");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			Member member = new Member(
				rs.getInt("mem_idx"),
				rs.getString("mem_id"),
				rs.getString("mem_nick"),
				rs.getString("mem_passwd"),
				rs.getString("mem_email"),
				rs.getString("mem_st"),
				rs.getString("mem_auth"),
				rs.getDate("reg_date"),
				rs.getDate("mod_date")
			);
			
			System.out.println(member.toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
