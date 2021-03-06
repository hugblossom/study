package com.myapp.handler.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.dao.MemberDAO;
import com.myapp.handler.DefaultHandler;

public class JoinHandler implements DefaultHandler {
	
	private String view = "/WEB-INF/views/template.jsp";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		if ( request.getMethod().equalsIgnoreCase("get") ) {
			
			request.setAttribute("jsp", "member/join.jsp");
			
		}
		
		if ( request.getMethod().equalsIgnoreCase("post") ) {
			
			String id = request.getParameter("userId");
			String pw = request.getParameter("userPasswd");
			String email = request.getParameter("userEmail");
			
			System.out.println(id + " / " + pw + " / " + email);
			
			MemberDAO memberDAO = new MemberDAO();
			
			boolean validate = memberDAO.insertCheck(id, pw, email);
			
			if ( validate ) {
				
				memberDAO.insert(id, pw, email);
				
				request.setAttribute("resultCode", "0000");
				
			} else {
				
				request.setAttribute("resultCode", "0001");
				
			}
			
			request.setAttribute("jsp", "member/join.jsp");
			
		}
		
		return view;
	}
}
