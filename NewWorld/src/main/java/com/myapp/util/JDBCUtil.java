package com.myapp.util;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static void autoCommitTrue(Connection conn) {
		try {
			conn.setAutoCommit(true);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
