package com.myapp.vo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myapp.util.Notification;

public class MemberTest {

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
	public void 멤버_검증() {
		Member member = new Member();
		member.setMem_id("stephy");
		member.setMem_nick("용신");
		member.setMem_passwd("");
		member.setMem_passwd_confirm("");
		member.setMem_email("");
		
		Notification noti = member.validateJoin();
		System.out.println(noti.toString());
	}

}
