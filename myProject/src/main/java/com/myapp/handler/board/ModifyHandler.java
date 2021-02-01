package com.myapp.handler.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.dao.BoardDAO;
import com.myapp.handler.DefaultHandler;
import com.myapp.vo.Article;
import com.myapp.vo.Member;

public class ModifyHandler implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
			
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		if  ( "GET".equalsIgnoreCase(request.getMethod()) ) {
			String paramIdx = request.getParameter("idx");
			int idx = Integer.parseInt(paramIdx);
			BoardDAO boardDAO = new BoardDAO();
			Article article = boardDAO.select(idx);
			
			request.setAttribute("article", article);
			request.setAttribute("jsp", "board/modify.jsp");
		}
		if  ( "POST".equalsIgnoreCase(request.getMethod()) ) {
			String paramIdx = request.getParameter("idx");
			int idx = Integer.parseInt(paramIdx);
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			String writer = member.getId();
			
			BoardDAO boardDAO = new BoardDAO();
			boolean flag = boardDAO.update(idx, title, contents, writer);
			
			if ( flag ) {
				request.setAttribute("resultCode", "0000");
			} else {
				request.setAttribute("resultCode", "0001");
			}
			
			Article article = boardDAO.select(idx);
			
			request.setAttribute("article", article);
			request.setAttribute("jsp", "board/detail.jsp");
			
			return view;
		}
		
		return view;
	}
}
