package com.myapp.mybatis.mapper;

import java.util.List;

import com.myapp.domain.Member;

public interface MemberImpl {
	public int insert(Member member);
	public int selectCount();
	public Member selectById(String mem_id);
	public Member selectByIdAndPasswd(Member member);
	public List<Member> selectList();
	public int update(Member member);
	public int updateAuthByIdx(Member member);
	public int deleteByIdx(int mem_idx);
	
}
