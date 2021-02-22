package com.myapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myapp.dao._MemberDAO;
import com.myapp.exception.MemberJoinFailedException;
import com.myapp.util.JDBCUtil;
import com.myapp.vo.Member;

public class MemberJoinService {
	Connection conn	= null;
	_MemberDAO dao	= new _MemberDAO();
	
	public boolean join(Member member) {
		boolean flag = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stephy?&useSSL=false", "root", "2002");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		try {
			conn.setAutoCommit(false);
			
			int rs1 = dao.insertMember(conn, member);
			
			if (rs1 <= 0) {
				throw new MemberJoinFailedException("member insert failed - param: " + member.toString());
			}
			
			int rs2 = dao.insertAddon(conn, member.getMem_id());
			
			if (rs2 <= 0) {
				throw new MemberJoinFailedException("addon insert failed - param: " + "abcd");
			}
			
			conn.commit();
			flag = true;
			
		} catch (Exception e) {
			JDBCUtil.rollback(conn);
		} finally {
			JDBCUtil.close(conn);
			JDBCUtil.autoCommitTrue(conn);
		}
		
		return flag;
	}
	
}
