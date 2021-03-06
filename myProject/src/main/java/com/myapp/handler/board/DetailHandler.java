package com.myapp.handler.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.dao.BoardDAO;
import com.myapp.handler.DefaultHandler;
import com.myapp.vo.Article;

public class DetailHandler implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
			
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String paramIdx = request.getParameter("idx");
		int idx = Integer.parseInt(paramIdx);
		
		BoardDAO boardDAO = new BoardDAO();
		Article article = boardDAO.select(idx);
		
		if ( article == null ) {
			request.setAttribute("jsp", "error/error404.jsp");
		} else {
			request.setAttribute("article", article);
			request.setAttribute("jsp", "board/detail.jsp");
		}
		
		return view;
	}
}
