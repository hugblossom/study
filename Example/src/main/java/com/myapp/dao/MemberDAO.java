package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.myapp.vo.Article;
import com.myapp.vo.Member;

public class MemberDAO {
	
	public List<Member> selectList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<>();
		
		String sql = "SELECT * FROM t_member WHERE st = '1'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while ( rs.next() ) {
			Member temp = 
					Member
					.builder()
					.uid(rs.getInt("uid"))
					.id(rs.getString("id"))
					.nick(rs.getString("nick"))
					.passwd(rs.getString("passwd"))
					.email(rs.getString("email"))
					.regDate(rs.getDate("reg_date"))
					.modDate(rs.getDate("mod_date"))
					.build();
			list.add(temp);
		}
	
		return list;
	}
	
	public Member selectByUid(Connection conn, String uid) throws SQLException {
		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_member WHERE uid = ? AND st = '1'";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.valueOf(uid)); //Integer(랩퍼클래스) .valueOf 는 변환될수있는 String값 받아서 변환해줌
		rs = pstmt.executeQuery();
		
		if ( !rs.next() ) {
			throw new RuntimeException("article is not exist");
		}
		
		result = 
				Member
				.builder()
				.uid(rs.getInt("uid"))
				.id(rs.getString("id"))
				.nick(rs.getString("nick"))
				.passwd(rs.getString("passwd"))
				.email(rs.getString("email"))
				.regDate(rs.getDate("reg_date"))
				.modDate(rs.getDate("mod_date"))
				.build();
		
		return result;
		
	}
	
	public Member login(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member result = null;
		String sql = "";
		
		sql += "SELECT ";
	    sql += "   A.* ";
	    sql += "   , B.exp ";
	    sql += "   , B.lv ";
	    sql += "   , B.pt ";
	    sql += "   , B.cash ";
	    sql += "FROM ";
	    sql += "   t_member A ";
	    sql += "   , t_member_addon B ";
	    sql += "WHERE ";
	    sql += "   A.id = ? ";
	    sql += "   AND A.passwd = ? ";
	    sql += "   AND B.uid = A.uid ";
	    sql += "   AND B.id = A.id ";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPasswd());
		rs = pstmt.executeQuery();
		
		if ( rs.next() ) {
			result = Member.builder()
					.uid(rs.getInt("uid"))
					.id(rs.getString("id"))
					.nick(rs.getString("nick"))
					.passwd(rs.getString("passwd"))
					.email(rs.getString("email"))
					.st(rs.getString("st"))
					.role(rs.getString("role"))
					.exp(rs.getInt("exp"))
					.lv(rs.getInt("lv"))
					.pt(rs.getInt("pt"))
					.cash(rs.getInt("cash"))
					.build();
		}
		
		
		return result;
	}
	
	public int insert(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt   = null;
		int result            = 0;
		String sql            = "INSERT INTO t_member(id, nick, passwd, email, reg_date, mod_date) VALUES(?, ?, ?, ?, NOW(), NOW())";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getNick());
		pstmt.setString(3, member.getPasswd());
		pstmt.setString(4, member.getEmail());
		result = pstmt.executeUpdate();
		
		return result;
	}
	
	public int update(Connection conn, Member member) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_member SET nick = ?, passwd = ?, email = ? WHERE uid = ?";
		
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getNick());
		pstmt.setString(2, member.getPasswd());
		pstmt.setString(3, member.getEmail());
		result = pstmt.executeUpdate();
		
		return result;
	}
	
	public int addon(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt   = null;
		ResultSet rs = null;
		int uid = 0;
		int result = 0;
		String sql = "SELECT LAST_INSERT_ID() AS uid"; //LAST_INSERT_ID() 마지막으로 insert된 auto increment된 값
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rs.next();
		uid = rs.getInt("uid");
		
		if ( uid >= 1 ) {
			sql = "INSERT INTO t_member_addon(uid, id) VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		}
				
		return result;
	}
	
	public int history(Connection conn, Member member) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO t_member_history(";
		
		if ( !StringUtils.isEmpty(member.getNick()) ) {
			sql += "nick, ";
		}
		if ( !StringUtils.isEmpty(member.getPasswd()) ) {
			sql += "passwd, ";
		}
		if ( !StringUtils.isEmpty(member.getEmail()) ) {
			sql += "email, ";
		}
		if ( !StringUtils.isEmpty(member.getSt()) ) {
			sql += "st, ";
		}
		if ( !StringUtils.isEmpty(member.getRole()) ) {
			sql += "role, ";
		}
		
		sql = sql.substring(0, sql.lastIndexOf(","));
		
		sql += ") VALUES (";
		
		if ( !StringUtils.isEmpty(member.getNick()) ) {
			sql += "'" + member.getNick() + "', ";
		}
		if ( !StringUtils.isEmpty(member.getPasswd()) ) {
			sql += "'" + member.getPasswd() + "', ";
		}
		if ( !StringUtils.isEmpty(member.getEmail()) ) {
			sql += "'" + member.getEmail() + "', ";
		}
		if ( !StringUtils.isEmpty(member.getSt()) ) {
			sql += "'" + member.getSt() + "', ";
		}
		if ( !StringUtils.isEmpty(member.getRole()) ) {
			sql += "'" + member.getRole() + "', ";
		}
		
		sql = sql.substring(0, sql.lastIndexOf(","));
		
		sql += ")";
		
		pstmt = conn.prepareStatement(sql);
		
		
		return result = pstmt.executeUpdate();
	}
	
	
	
	public int delete(Connection conn, int uid) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_member SET st = 0 WHERE uid = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, uid);
		result = pstmt.executeUpdate();
		
		return result;
	}
}
