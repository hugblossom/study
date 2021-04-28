package com.myapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class MemberController {
	
	@GetMapping("/list")
	public String getList() {
		return "admin/member/list";
	}
	
	@GetMapping("/detail")
	public String getDetail() {
		return "admin/member/detail";
	}
}
