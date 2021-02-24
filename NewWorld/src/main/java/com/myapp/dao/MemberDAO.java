package com.myapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myapp.domain.Member;
import com.myapp.mybatis.mapper.MemberImpl;

public class MemberDAO {
	public int getCount(SqlSession session) throws SQLException {
		return session.getMapper(MemberImpl.class).selectCount();
	}
	
	public Member getMember(SqlSession session, String mem_id) throws SQLException {
		return session.getMapper(MemberImpl.class).selectById(mem_id);
	}
	
	public Member getMemberByIdx(SqlSession session, int mem_idx) throws SQLException {
		return session.getMapper(MemberImpl.class).selectByIdx(mem_idx);
	}
	
	public List<Member> getMemberList(SqlSession session) throws SQLException {
		return session.getMapper(MemberImpl.class).selectList();
	}
	
	public int setMember(SqlSession session, Member member) throws SQLException {
		return session.getMapper(MemberImpl.class).update(member);
	}
}