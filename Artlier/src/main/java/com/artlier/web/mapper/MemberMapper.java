package com.artlier.web.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artlier.web.domain.ArticleCommon;
import com.artlier.web.domain.Member;
import com.artlier.web.dto.JoinDTO;
import com.artlier.web.dto.LoginDTO;
import com.artlier.web.dto.LoginHistoryDTO;
import com.artlier.web.dto.NotificationDTO;
import com.artlier.web.dto.PaginationDTO;

@Mapper
public interface MemberMapper {
	
	List<Member> selectAll() throws SQLException;
	int memberJoin(JoinDTO dto) throws SQLException;
	Member selectById(LoginDTO dto) throws SQLException;
	Member memberLogin(LoginDTO dto) throws SQLException;
	int loginHistory(LoginHistoryDTO dto) throws SQLException;
	int idExist(String memId) throws SQLException;
	List<NotificationDTO> selectNotificationListById(String memId) throws SQLException;
	int updateNotificationChecked(NotificationDTO dto) throws SQLException;
	int deleteTargetNotification(NotificationDTO dto) throws SQLException;
	int deleteAllNotification(NotificationDTO dto) throws SQLException;
	List<LoginHistoryDTO> selectMyLoginHistory(String memId) throws SQLException;
	int countMyCommonList(String memId) throws SQLException;
	List<ArticleCommon> selectMyCommonListByPage(PaginationDTO dto) throws SQLException;
	
}
