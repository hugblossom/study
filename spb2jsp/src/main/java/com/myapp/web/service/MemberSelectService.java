package com.myapp.web.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.web.config.ConnectionManager;
import com.myapp.web.dao.MemberDAO;
import com.myapp.web.domain.Member;

@Service
public class MemberSelectService {
	
	Connection conn = ConnectionManager.getConnection();
	
	@Autowired
	MemberDAO dao;
	
	public int selectCount() {
		int result = 0;
			
		result = dao.selectCount(conn);
		
		return result;
	}
	
	public List<Member> selectAll() {
		List<Member> memberList = null;
		
		memberList = dao.selectAll(conn);
				
		return memberList;
	}
	
}
