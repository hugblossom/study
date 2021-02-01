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

public class ListHandler implements DefaultHandler {
	private String view = "/WEB-INF/views/template.jsp";
			
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setAttribute("jsp", "board/list.jsp");
		
		BoardDAO boardDAO = new BoardDAO();
		List<Article> articleList = boardDAO.getList();
		
		request.setAttribute("articleList", articleList);
		
		return view;
	}
}
