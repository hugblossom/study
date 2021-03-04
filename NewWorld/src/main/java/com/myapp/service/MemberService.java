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
import com.myapp.servlet.SqlSessionManager;

public class MemberService {
	static SqlSessionFactory factory = SqlSessionManager.getSqlSessionFactory();
	MemberDAO dao = new MemberDAO();	
	
	public int getCount() throws SQLException {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = dao.getCount(session);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public Member selectById(String mem_id) throws SQLException {
		
		try ( SqlSession session = factory.openSession()) {
			return dao.selectById(session, mem_id);
		}
	}
	
	public Member getMemberByIdx(int mem_idx) throws SQLException {
		
		try ( SqlSession session = factory.openSession()) {
			return dao.getMemberByIdx(session, mem_idx);
		}
	}
	
	public List<Member> getMemberList() throws SQLException {
		
		try ( SqlSession session = factory.openSession()) {
			return dao.getMemberList(session);
		}
	}
	
	public int setMember(Member member) throws SQLException {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = dao.setMember(session, member);
		} catch( Exception e ) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public int update(Member member) throws Exception {
		
		int result = 0;
		
		SqlSession session = factory.openSession();
		
		try {
			result = dao.update(session, member);
			session.commit();
		} catch ( Exception e ) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}
	
}
