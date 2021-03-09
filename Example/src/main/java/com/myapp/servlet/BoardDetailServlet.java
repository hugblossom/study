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

@WebServlet(urlPatterns = {"/board/detail"}) //대신 web.xml에 등록해줘도됨
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardDetailServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		
		BoardDAO dao = new BoardDAO();
		Article article = dao.selectByUid(uid);
		
		request.setAttribute("article", article);
		RequestDispatcher rd = request.getRequestDispatcher("/views/board/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
