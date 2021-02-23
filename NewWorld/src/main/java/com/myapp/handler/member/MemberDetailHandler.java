package com.myapp.handler.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.domain.Member;
import com.myapp.handler.DefaultHandler;
import com.myapp.service.MemberService;

public class MemberDetailHandler implements DefaultHandler { // NullHandler라고도 함
	String view = "member/detail";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String mem_id = request.getParameter("mem_id");
		MemberService service = new MemberService();
		
		Member member = service.getMember(mem_id);
		
		request.setAttribute("member", member);
	
		return view;
	}
}
