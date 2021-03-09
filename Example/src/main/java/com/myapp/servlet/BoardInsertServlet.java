package com.myapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.dao.BoardDAO;
import com.myapp.vo.Article;

@WebServlet(urlPatterns = {"/board/insert"}) //대신 web.xml에 등록해줘도됨
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardInsertServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/board/insert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Article article = Article
				.builder()
				.kind("A")
				.title(title)
				.content(content)
				.memId("stephy")
				.build();
		BoardDAO dao = new BoardDAO();
		int result = dao.insert(article);
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/list");
		rd.forward(request, response);
		
	}

}
