package com.myapp.handler.error;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.handler.DefaultHandler;

public class Error404Handler implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
			
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setAttribute("jsp", "error/error404.jsp");
		
		return view;
	}
}
