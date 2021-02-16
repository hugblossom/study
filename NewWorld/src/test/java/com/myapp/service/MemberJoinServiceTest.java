package com.myapp.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myapp.dao.MemberDAO;
import com.myapp.vo.Member;

public class MemberJoinServiceTest {

	@BeforeClass // 가장 처음 실행
	public static void setUpBeforeClass() throws Exception {
	}

	@Before // 테스트 직전에 실행
	public void setUp() throws Exception {
	}
	
	@Test
	public void 멤버_가입_될거임() {
		Member member = new Member();
		member.setMem_id("testtttt");
		member.setMem_nick("testtttt");
		member.setMem_passwd("testtttt");
		member.setMem_email("testtttt@naver.com");
		
		MemberJoinService mjs = new MemberJoinService();
		boolean flag = mjs.join(member);
		
		Assert.assertTrue(flag);
		
		System.out.println(flag);
	}

	@After // 테스트 직후에 실행
	public void tearDown() throws Exception {
		MemberJoinService mjs = new MemberJoinService();
		mjs.delete();
	}

	@AfterClass // 가장 마지막 실행
	public static void tearDownAfterClass() throws Exception {
	}
	
}
