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

@WebServlet(urlPatterns = {"/board/delete"}) //대신 web.xml에 등록해줘도됨
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardDeleteServlet() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		
		BoardDAO dao = new BoardDAO();
		dao.delete(Integer.valueOf(uid));
		
		response.sendRedirect("/board/list");
	}

}
