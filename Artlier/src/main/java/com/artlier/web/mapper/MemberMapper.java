package com.artlier.web.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artlier.web.domain.Member;
import com.artlier.web.dto.JoinDTO;
import com.artlier.web.dto.LoginDTO;
import com.artlier.web.dto.LoginHistoryDTO;

@Mapper
public interface MemberMapper {
	
	List<Member> selectAll() throws SQLException;
	int memberJoin(JoinDTO dto) throws SQLException;
	Member selectById(LoginDTO dto) throws SQLException;
	Member memberLogin(LoginDTO dto) throws SQLException;
	int loginHistory(LoginHistoryDTO dto) throws SQLException;
	
	int idExist(String memId) throws SQLException; 
	
}
