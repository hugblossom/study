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

@WebServlet(urlPatterns = {"/board/goodbad"}) //대신 web.xml에 등록해줘도됨
public class BoardGoodBadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardGoodBadServlet() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String mod = request.getParameter("mod");
		
		BoardDAO dao = new BoardDAO();
		dao.updateGoodBad(mod, Integer.valueOf(uid));
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/detail?uid=" + uid);
		rd.forward(request, response);
	}

}
