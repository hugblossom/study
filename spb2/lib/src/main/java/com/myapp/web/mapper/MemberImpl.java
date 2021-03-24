package com.myapp.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myapp.web.domain.Member;

@Repository
public interface MemberImpl {

	int selectCount();
	List<Member> selectAll();

}
