package com.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public Member selectById(Connection conn, String mem_id) throws SQLException {
		String sql = "SELECT * FROM t_member WHERE mem_id = ?";
		Member member = new Member();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mem_id);
		rs = pstmt.executeQuery();
		
		if ( rs.next() ) {
			member.setMem_idx(rs.getInt("mem_idx"));
			member.setMem_id(rs.getString("mem_id"));
			member.setMem_nick(rs.getString("mem_nick"));
			member.setMem_passwd(rs.getString("mem_passwd"));
			member.setMem_email(rs.getString("mem_email"));
			member.setMem_st(rs.getString("mem_st"));
			member.setMem_auth(rs.getString("mem_auth"));
			member.setReg_date(rs.getDate("reg_date"));
			member.setMod_date(rs.getDate("mod_date"));
		}
		
		return member;
	}
	
	public List<Member> selectList(Connection conn) throws SQLException {
		List<Member> memberList = new ArrayList<>();
		String sql = "SELECT * FROM t_member";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while( rs.next() ) {
			Member temp = new Member();
			temp.setMem_idx(rs.getInt("mem_idx"));
			temp.setMem_id(rs.getString("mem_id"));
			temp.setMem_nick(rs.getString("mem_nick"));
			temp.setMem_passwd(rs.getString("mem_passwd"));
			temp.setMem_email(rs.getString("mem_email"));
			temp.setMem_st(rs.getString("mem_st"));
			temp.setMem_auth(rs.getString("mem_auth"));
			temp.setReg_date(rs.getDate("reg_date"));
			temp.setMod_date(rs.getDate("mod_date"));
			
			memberList.add(temp);
		}
			
		return memberList;
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
