package com.myapp.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.web.domain.Member;
import com.myapp.web.mapper.MemberImpl;

@Repository
public class MemberDAO {
	
	@Autowired
	MemberImpl mapper;
	
	public int selectCount() {
		return mapper.selectCount();
	}
	
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
}
