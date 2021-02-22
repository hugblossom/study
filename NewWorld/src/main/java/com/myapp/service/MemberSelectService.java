package com.myapp.service;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.myapp.dao.MemberDAO;
import com.myapp.domain.Member;

public class MemberSelectService {
	static SqlSessionFactory factory;
	SqlSession session;
	MemberDAO dao = new MemberDAO();
	
	public MemberSelectService() {
		
		try {

			InputStream is = Resources.getResourceAsStream("com/myapp/mybatis/mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (Exception e) {
			
		}
		
	}
	
	public int getCount() throws SQLException {
		session = factory.openSession();
		return dao.getCount(session);
	}
	
	public Member getMember(String mem_id) throws SQLException {
		session = factory.openSession();
		return dao.getMember(session, mem_id);
	}
	
	public List<Member> getMemberList() throws SQLException {
		session = factory.openSession();
		return dao.getMemberList(session);
	}
	
}
