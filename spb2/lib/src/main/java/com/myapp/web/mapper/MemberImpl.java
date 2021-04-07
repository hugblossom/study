package com.myapp.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.web.domain.Member;
import com.myapp.web.dto.MemberInsertDTO;

@Mapper
public interface MemberImpl {

	int selectCount();
	List<Member> selectAll();
	int insert(MemberInsertDTO dto);
	Member selectByIdAndPassword(Map<String, String> map);
	
}
