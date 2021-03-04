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

public class MemberInsertHandler implements DefaultHandler { // NullHandler라고도 함
	String view = "member/insert";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		return view;
	}
}
