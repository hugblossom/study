package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myapp.vo.Article;

public class BoardDAO {
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
	
	public List<Article> selectList() {
		List<Article> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM t_board";

			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				Article temp = 
						Article
						.builder()
						.uid(rs.getInt("uid"))
						.kind(rs.getString("kind"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.memId(rs.getString("mem_id"))
						.good(rs.getInt("good"))
						.bad(rs.getInt("bad"))
						.st(rs.getString("st"))
						.passwd(rs.getString("passwd"))
						.st(rs.getString("st"))
						.regDate(rs.getDate("reg_date"))
						.modDate(rs.getDate("mod_date"))
						.build();
				list.add(temp);
				
			}
					
		} catch( Exception e ) {
			System.out.println( "e: " + e.getMessage() );
		} finally {
			
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch ( Exception e ) {
				
			}
		} 
	
		return list;
	}
	
	public Article selectByUid(String uid) {
		Article result = null;
		String sql = "SELECT * FROM t_board WHERE uid = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(uid)); //Integer(랩퍼클래스) .valueOf 는 변환될수있는 String값 받아서 변환해줌
			rs = pstmt.executeQuery();
			
			if ( !rs.next() ) {
				throw new RuntimeException("article is not exist");
			}
			
			result = 
					Article
					.builder()
					.uid(rs.getInt("uid"))
					.kind(rs.getString("kind"))
					.title(rs.getString("title"))
					.content(rs.getString("content"))
					.memId(rs.getString("mem_id"))
					.good(rs.getInt("good"))
					.bad(rs.getInt("bad"))
					.st(rs.getString("st"))
					.passwd(rs.getString("passwd"))
					.st(rs.getString("st"))
					.regDate(rs.getDate("reg_date"))
					.modDate(rs.getDate("mod_date"))
					.build();
			
		} catch( Exception e ) {

			System.out.println("e: " + e.getMessage());
			
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch ( Exception e ) {
				
			}
		}
		
		return result;
		
	}
	
	public int insert(Article article) {
		
		int result = 0;
		String sql = "INSERT INTO t_board(kind, title, content, mem_id, reg_date, mod_date) VALUES(?, ?, ?, ?, NOW(), NOW())";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getKind());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getMemId());
			
			result = pstmt.executeUpdate();
		
		} catch ( Exception e ) {
			
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch ( Exception e ) {
				
			}
		}
		
		return result;
	}
}
