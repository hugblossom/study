package com.myapp.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myapp.vo.Member;

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
	public void 멤버_조회() {
		try {
			Member member = service.getMember("yong");
			
			if ( member.getMem_idx() == 0 ) {
				throw new RuntimeException();
			}
			
			System.out.println(member.toString());
			
		} catch (Exception e) {
			System.out.println("해당 회원은 존재하지 않습니다.");
		}
	}
	
	@Test
	public void 멤버_리스트_조회() {
		try {
			List<Member> memberList = service.getMemberList();
			
			if (memberList.size() <= 0) {
			
				throw new RuntimeException();
				
			}
			
			for ( Member m : memberList) {
				System.out.println(m.toString());
			}
			
		} catch (Exception e) {
			System.out.println("회원이 존재하지 않습니다.");
		}
	}

}
