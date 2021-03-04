package com.myapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.myapp.domain.Article;
import com.myapp.domain.Member;
import com.myapp.mybatis.mapper.BoardImpl;

public class BoardDAO {
	public int selectCount(SqlSession session) throws SQLException {
		return session.getMapper(BoardImpl.class).selectCount();
	}
	
	public List<Article> selectById(SqlSession session, String mem_id) throws SQLException {
		return session.getMapper(BoardImpl.class).selectById(mem_id);
	}
	
	public List<Article> selectAll(SqlSession session) throws SQLException {
		return session.getMapper(BoardImpl.class).selectAll();
	}
	
	public Article selectByIdx(SqlSession session, int art_idx) throws SQLException {
		return session.getMapper(BoardImpl.class).selectByIdx(art_idx);
	}
	
	public int insert(SqlSession session, Article article) throws SQLException {
		return session.getMapper(BoardImpl.class).insert(article);
	}
}