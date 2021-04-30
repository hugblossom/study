package com.artlier.web.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artlier.web.domain.ArticleCommon;
import com.artlier.web.dto.BoardCommonModifyDTO;
import com.artlier.web.dto.BoardCommonWriteDTO;
import com.artlier.web.dto.PaginationDTO;

@Mapper
public interface BoardMapper {
	
	List<ArticleCommon> selectCommonList() throws SQLException;
	List<ArticleCommon> selectCommonListByPage(PaginationDTO dto) throws SQLException;
	int countCommonList() throws SQLException;
	ArticleCommon selectCommonListByUid(int uid) throws SQLException;
	int boardCommonWrite(BoardCommonWriteDTO dto) throws SQLException;
	int boardCommonModify(BoardCommonModifyDTO dto) throws SQLException;
	
}
