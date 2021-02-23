package com.myapp.handler.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.handler.DefaultHandler;
import com.myapp.service.MemberService;
import com.myapp.domain.Member;

public class MemberListHandler implements DefaultHandler { // NullHandler라고도 함
	String view = "member/list";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
		MemberService service = new MemberService();
		List<Member> memberList = service.getMemberList();
		request.setAttribute("memberList", memberList);
		
		return view;
	}
}
