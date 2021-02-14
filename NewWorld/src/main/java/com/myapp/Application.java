package com.myapp;

import com.myapp.vo.Member;

public class Application {

	public static void main(String[] args) {
		Member member = new Member();
		
		member.setMemberId("stephy");
		member.setMemberEmail("stephy@naver.com");
		
		System.out.println(member.toString());
	}

}
