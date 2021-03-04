package com.myapp.handler.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.handler.DefaultHandler;
import com.myapp.service.BoardService;
import com.myapp.service.MemberService;
import com.myapp.domain.Article;
import com.myapp.domain.Member;

public class BoardListHandler implements DefaultHandler { // NullHandler라고도 함
	String view = "board/list";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		BoardService service = new BoardService();
		List<Article> articleList = new ArrayList<>();
		
		try {
			articleList = service.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("articleList", articleList);
		
		return view;
	}
}
