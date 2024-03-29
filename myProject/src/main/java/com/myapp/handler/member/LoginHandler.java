package com.myapp.handler.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.dao.MemberDAO;
import com.myapp.handler.DefaultHandler;
import com.myapp.vo.Member;

public class LoginHandler implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		if ( request.getMethod().equalsIgnoreCase("get") ) {
			
			request.setAttribute("jsp", "member/login.jsp");
			
		} else {

			String id = request.getParameter("userId");
			String pw = request.getParameter("userPasswd");
			
			MemberDAO memberDAO = new MemberDAO();
			Member member = memberDAO.login(id, pw);
			HttpSession session = request.getSession();
			
			if ( member.getId().equals("") || member.getId() == null ) {
				session.invalidate();
			} else {
				session.setAttribute("member", member);
			}
			
			request.setAttribute("jsp", "interface/main.jsp");
			
		}
		
		return view;
	}
}
