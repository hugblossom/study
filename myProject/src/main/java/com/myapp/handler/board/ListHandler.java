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
		
		String paramPageNum = request.getParameter("pageNum");
		String paramPageCnt = request.getParameter("PageCnt");
		
		int pageNum;
		int pageCnt;
		int totalCnt;
		int pages;
		
		if ( "".equals(paramPageNum) || paramPageNum == null ) {
			pageNum = 1;
		} else {
			pageNum = Integer.parseInt(paramPageNum);
		}
		
		if ( "".equals(paramPageCnt) || paramPageCnt == null ) {
			pageCnt = 10;
		} else {
			pageCnt = Integer.parseInt(paramPageCnt);
		}
		
		BoardDAO boardDAO = new BoardDAO();
		List<Article> articleList = boardDAO.getListByCondition(pageNum, pageCnt);
		totalCnt = boardDAO.getListCnt();
		
		pages = (int) ( totalCnt / pageCnt );
		
		if ( totalCnt % pageCnt > 0 ) {
			pages += 1;
		}
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("pages", pages);
		
		request.setAttribute("jsp", "board/list.jsp");
		
		return view;
	}
}
