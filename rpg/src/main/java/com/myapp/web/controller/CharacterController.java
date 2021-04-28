package com.myapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/character")
public class CharacterController {
	
	@GetMapping("/list")
	public String getList() {
		return "admin/charater/list";
	}
	
	@GetMapping("/detail")
	public String getDetail() {
		return "admin/character/detail";
	}
	
	@PostMapping("/modify")
	public String postMapping() {
		return "admin/character/modify";
	}
	
}
