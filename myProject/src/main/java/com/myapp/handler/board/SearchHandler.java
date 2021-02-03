package com.myapp.handler.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.dao.BoardDAO;
import com.myapp.handler.DefaultHandler;
import com.myapp.vo.Article;

public class SearchHandler implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
			
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		if ( "GET".equalsIgnoreCase(request.getMethod()) ) {
			String type = request.getParameter("type");
			String word = request.getParameter("word");
			
			BoardDAO boardDAO = new BoardDAO();
			List<Article> articleList = boardDAO.getListBySearch(type, word);
			
			request.setAttribute("articleList", articleList);
			
		}
		
		if ( "POST".equalsIgnoreCase(request.getMethod()) ) {
			
		}
		
		request.setAttribute("jsp", "board/list.jsp");
		
		return view;
	}
}