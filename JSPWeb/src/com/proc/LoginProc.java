package com.proc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vo.Member;

public class LoginProc {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String dbUrl = "jdbc:mysql://localhost/stephy?&useSSL=false";
	String dbId = "root";
	String dbPasswd = "2002";
	
	
	public Member getLogin(Member input) {
		Member in = input;
		String in_id = in.getId();
		String in_pw = in.getPasswd();
		
		String out_idx = "";
		String out_id = "";
		String out_passwd = "";
		String out_email = "";
		
		if ("".equals(in_id) || in_id == null) {
			throw new RuntimeException("아이디를 입력하세요");
		}
		
		if ("".equals(in_pw) || in_pw == null) {
			throw new RuntimeException("패스워드를 입력하세요");
		}
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPasswd);
			
			String sql = "SELECT idx, id, passwd, email FROM t_member WHERE id = ? AND passwd = ?";
			
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_id);
			pstmt.setString(2, in_pw);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			out_idx		= rs.getString("idx");   
			out_id		= rs.getString("id");    
			out_passwd	= rs.getString("passwd");
			out_email	= rs.getString("email"); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("데이터 베이스 접속에 실패하였습니다.");
		} finally {
			conn	= null;
			pstmt	= null;
			rs		= null;
		}
		
		return new Member(out_idx, out_id, out_passwd, out_email);
	}
	
	public boolean setMember(Member member) {
		boolean isSuccess	= false;
		String sql			= "";
		
		Member in			= member;
		String in_id		= in.getId();
		String in_passwd	= in.getPasswd();
		String in_email		= in.getEmail();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPasswd);
			
			//String sql = "INSERT INTO t_member(id, passwd, email) VALUES";
			StringBuilder sqlSB = new StringBuilder();
			sqlSB.append("INSERT INTO ");
			sqlSB.append("	t_member(id, passwd, email) ");
			sqlSB.append("VALUES ");
			sqlSB.append("	(?, ?, ?)");
			
			sql = sqlSB.toString();
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_id);
			pstmt.setString(2, in_passwd);
			pstmt.setString(3, in_email);
			
			if (pstmt.executeUpdate() == 1) {
				isSuccess = true;
			}

		} catch (Exception e) {
			throw new RuntimeException("데이터 베이스 접속에 실패하였습니다.");
		}  finally {
			conn	= null;
			pstmt	= null;
			rs		= null;
		}
		
		return isSuccess;
	}
	
	public boolean checkId(Member member) {
		boolean isExist = false;
		
		Member in		= member;
		String in_id	= in.getId(); 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbId, dbPasswd);
			
			String sql = "SELECT COUNT(id) AS cnt FROM t_member WHERE id = ?";
			
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_id);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			if (rs.getInt("cnt") >= 1) {
				isExist = true;
			}

		} catch (Exception e) {
			throw new RuntimeException("데이터 베이스 접속에 실패하였습니다.");
		}  finally {
			conn	= null;
			pstmt	= null;
			rs		= null;
		}
		
		return isExist;
	}
}


