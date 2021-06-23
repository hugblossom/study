package com.artlier.web.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artlier.web.domain.ArticleCommon;
import com.artlier.web.dto.BoardCommonHistoryDTO;
import com.artlier.web.dto.BoardCommonModifyDTO;
import com.artlier.web.dto.BoardCommonReplyDTO;
import com.artlier.web.dto.BoardCommonWriteDTO;
import com.artlier.web.dto.BoardToken;
import com.artlier.web.dto.NotificationDTO;
import com.artlier.web.dto.PaginationDTO;

@Mapper
public interface BoardMapper {
	
	List<ArticleCommon> selectCommonList(String code) throws SQLException;
	List<ArticleCommon> selectCommonListByPage(PaginationDTO dto) throws SQLException;
	int selectLastInsertId(BoardCommonWriteDTO dto) throws SQLException;
	int countCommonList(String code) throws SQLException;
	ArticleCommon selectCommonListByUid(ArticleCommon ac) throws SQLException;
	int boardCommonWrite(BoardCommonWriteDTO dto) throws SQLException;
	BoardCommonHistoryDTO selectBoardHistory(BoardCommonHistoryDTO dto) throws SQLException;
	int insertBoardHistory(BoardCommonHistoryDTO dto) throws SQLException;
	int insertBoardReply(BoardCommonReplyDTO dto) throws SQLException;
	int deleteBoardLikeHistory(BoardCommonHistoryDTO dto) throws SQLException;
	int boardCommonModify(BoardCommonModifyDTO dto) throws SQLException;
	int boardCommonDelete(BoardCommonModifyDTO dto) throws SQLException;
	List<BoardCommonReplyDTO> selectReplyListByUidAndSeq(BoardCommonReplyDTO dto) throws SQLException;
	int boardReplyModify(BoardCommonReplyDTO dto) throws SQLException;
	int boardReplyDelete(BoardCommonReplyDTO dto) throws SQLException;
	int boardCert(ArticleCommon ac) throws SQLException;
	int insertBoardToken(BoardToken bc) throws SQLException;
	BoardToken selectBoardToken(BoardToken bc) throws SQLException;
	int deleteExpiredBoardToken(BoardToken bc) throws SQLException;
	int insertNotification(NotificationDTO dto) throws SQLException;
	BoardCommonReplyDTO selectLastInsertReply(BoardCommonReplyDTO dto) throws SQLException;
	
}
