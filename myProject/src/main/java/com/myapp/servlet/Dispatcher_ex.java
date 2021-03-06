package com.myapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher_ex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dispatcher_ex() { super(); }
    
    public void init(ServletConfig config) throws ServletException {
    	String encoding = config.getInitParameter("encoding");
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length());
		String view = "/WEB-INF/views/template.jsp";
		
		if ("/main.do".equals(cmd)) {
			request.setAttribute("destination","/interface/main.jsp");
		} else if ("/board.do".equals(cmd)) {
			request.setAttribute("destination","/board/list.jsp");
		} else if ("/member.do".equals(cmd)) {
			request.setAttribute("destination","/member/list.jsp");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
