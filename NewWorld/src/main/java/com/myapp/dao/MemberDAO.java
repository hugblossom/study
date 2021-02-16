package com.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myapp.vo.Member;

public class MemberDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public int insertMember(Connection conn, Member member_in) throws SQLException {
		String sql = "INSERT INTO t_member(mem_id, mem_nick, mem_passwd, mem_email, reg_date, mod_date) "; 
			   sql += "VALUES (?, ?, ?, ?, NOW(), NOW())";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member_in.getMem_id());
		pstmt.setString(2, member_in.getMem_nick());
		pstmt.setString(3, member_in.getMem_passwd());
		pstmt.setString(4, member_in.getMem_email());
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public int insertAddon(Connection conn, String mem_id) throws SQLException {
		String sql = "INSERT INTO t_member_addon (mem_id, mod_date) VALUES (?, NOW())";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mem_id);
		int result = pstmt.executeUpdate();
		
		return result;
		
	}
	
	public void deleteLast(Connection conn) throws SQLException {
		String sql = "SELECT LAST_INSERT_ID() AS idx";
		int idx = 0;
		String mem_id = "";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		rs.next();
		idx = rs.getInt("idx");
		
		String sql2 = "SELECT mem_id FROM t_member WHERE mem_idx = ?";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setInt(1, idx);
		rs = pstmt.executeQuery();
		
		rs.next();
		mem_id = rs.getString("mem_id");
		
		String sql3 = "DELETE FROM t_member WHERE mem_idx = ?";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setInt(1, idx);
		pstmt.executeUpdate();
		
		String sql4 = "DELETE FROM t_member_addon WHERE mem_id = ?";
		pstmt = conn.prepareStatement(sql4);
		pstmt.setString(1, mem_id);
		pstmt.executeUpdate();
	}
}
