package com.myapp.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.myapp.web.domain.Member;

@Repository
@Mapper
public interface MemberMapper {
	int selectCount();
	List<Member> selectAll();
	Member selectById(String id);
}
