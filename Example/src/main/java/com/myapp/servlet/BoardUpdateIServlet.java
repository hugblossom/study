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

@WebServlet(urlPatterns = {"/board/update"}) //대신 web.xml에 등록해줘도됨
public class BoardUpdateIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardUpdateIServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		BoardDAO dao = new BoardDAO();
		Article article = dao.selectByUid(uid);
		
		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/board/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Article article = Article.builder()
				.uid(Integer.valueOf(uid))
				.title(title)
				.content(content)
				.build();
		
		BoardDAO dao = new BoardDAO();
		int result = dao.update(article);
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/detail?uid=" + uid);
		rd.forward(request, response);
		
	}

}
