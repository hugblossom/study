package com.myapp.mybatis.mapper;

import java.util.List;

import com.myapp.domain.Article;

public interface BoardImpl {
	List<Article> selectAll();
	Article selectByIdx(int art_idx);
	List<Article> selectById(String mem_id);
	int selectCount();
	int insert(Article article); //BoardSql.xml의 id와 일치하여야함
}
