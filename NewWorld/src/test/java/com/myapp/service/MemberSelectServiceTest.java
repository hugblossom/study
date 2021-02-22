package com.myapp.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myapp.domain.Member;

public class MemberSelectServiceTest {
	MemberSelectService service = new MemberSelectService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void 멤버_수_조회() throws Exception {
		System.out.println("member count is " + service.getCount() );
	}
	
	@Test
	public void 멤버_조회() throws Exception {
		System.out.println(
			"멤버 조회: " + service.getMember("stephy").toString()
		);
		
		List<Member> memberList = service.getMemberList();
		
		for ( Member member : memberList) {
			System.out.println("mem_id: " + member.getMem_id());
		}
	}
}
