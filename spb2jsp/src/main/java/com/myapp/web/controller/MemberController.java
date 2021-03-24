package com.myapp.web.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.web.dao.MemberDAO;
import com.myapp.web.domain.Member;
import com.myapp.web.mapper.MemberMapper;
import com.myapp.web.service.MemberSelectService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired MemberDAO dao;
	
	@Autowired
	MemberSelectService service;
	
	/*
	 * @Autowired DataSource ds;
	 */
	
	@Autowired
	@Qualifier("mybatisDS")
	DataSource ds;

	@Autowired
	private MemberMapper mapper;
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		
		List<Member> memberList = service.selectAll();
		model.addAttribute("memberList", memberList);
		
		return "member/list";
		
	}
	
	@GetMapping("/count")
	public String selectCount(Model model) {
		int count = service.selectCount();
		model.addAttribute("count", count);
		
		return "member/count";
	}
	
	@GetMapping("/select")
	public String selectInfo(Model model) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		List<Member> memberList = dao.selectAll(conn);
		model.addAttribute("memberList", memberList);
		
		int count = dao.selectCount(conn);
		model.addAttribute("count", count);
		
		return "member/select";
		
	}
	
	
	@GetMapping("/selectCount")
	public String mbSelectCount(Model model) {
		int count = mapper.selectCount();
		model.addAttribute("count", count);
		
		return "member/selectCount";
	}
	
	@GetMapping("/selectAll")
	public String mbSelectAll(Model model) {
		List<Member> memberList = mapper.selectAll();
		model.addAttribute("memberList", memberList);
		
		return "member/selectAll";
	}
	
	// 파라미터로받는법
	 // http://www.myapp.co.kr/member/selectById?nick=onigawara
	@GetMapping("/selectByIdParam")
	public String mbSelectById(Model model, @RequestParam("id") String id) {
		Member member = mapper.selectById(id);
		model.addAttribute("member", member);
		
		return "member/selectById";
	}
	
	// url로받는법
	 // http://www.myapp.co.kr/member/selectById/onigawara
	@GetMapping("/selectByIdUrl/{id}") // {내부이름}과 인수이름 일치해야함
	public String mbSelectById2(Model model, @PathVariable String id) {
		Member member = mapper.selectById(id);
		model.addAttribute("member", member);
		
		return "member/selectById";
	}
	
	// http://www.myapp.co.kr/member/selectById/onigawara?nick=이건별명
	@GetMapping("/selectByIdBoth/{id}")
	public String mbSelectById3(Model model, @PathVariable String id, @RequestParam("nick") String nick) {
	   Member member = mapper.selectById(id);
	   model.addAttribute("member", member);
	   model.addAttribute("nick", nick);
	   
	   return "member/selectById";
	}
	
}
