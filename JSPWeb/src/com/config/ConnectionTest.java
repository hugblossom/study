package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proc.LoginProc;
import com.vo.Member;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost/oni?&useSSL=false";
		String id = "onigawara";
		String passwd = "";
		
		String lid = "yeom";
		String lpw = "unhuman";
		
		try {
			
			System.out.println("연결을 시도합니다.");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, id, passwd);
			
			if (conn == null) {
				System.out.println("접속 실패");
			} else {
				System.out.println("접속 성공");
			}
			
			String sql = "SELECT * FROM t_member";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(
					"idx: "			+ rs.getInt("idx") +
					" / id: "		+ rs.getString("id") + 
					" / passwd: "	+ rs.getString("passwd") +
					" / email: "	+ rs.getString("email")
				);
			}
			
			
			conn.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
