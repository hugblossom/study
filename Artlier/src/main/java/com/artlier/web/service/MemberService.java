package com.artlier.web.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artlier.web.domain.Member;
import com.artlier.web.dto.JoinDTO;
import com.artlier.web.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	public List<Member> memberList() {
		
		List<Member> result = null;
		try {
			result = memberMapper.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
	}
	
	public int memberJoin(JoinDTO dto) {
		
		int result = 0;
		try {
			result = memberMapper.memberJoin(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
