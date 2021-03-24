package com.myapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.web.domain.Member;
import com.myapp.web.mapper.MemberImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberImpl memberMapper;
	
	@GetMapping("/join")
	public String getJoin() {
		return "/member/join";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "/member/login";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Member> memberList = memberMapper.selectAll();
		
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
		
	}
	
	/*
	 * @PostMapping("/join") public String postJoin() {
	 * 
	 * }
	 * 
	 * @PostMapping("/login") public String postLogin() {
	 * 
	 * }
	 */
}
