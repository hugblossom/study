package com.myapp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.myapp.dao.BoardDAO;
import com.myapp.domain.Article;
import com.myapp.servlet.SqlSessionManager;

public class BoardService {
	static SqlSessionFactory factory = SqlSessionManager.getSqlSessionFactory();
	BoardDAO dao = new BoardDAO();
	
	public List<Article> selectAll() throws Exception {
		SqlSession session = factory.openSession();
		
		return dao.selectAll(session);
	}
}
