package com.myapp.handler.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.handler.DefaultHandler;

public class Insert implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("UserId");
		String pw = request.getParameter("UserPw");
		String email = request.getParameter("UserEmail");
	}
}
