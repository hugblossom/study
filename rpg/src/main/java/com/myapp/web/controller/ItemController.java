package com.myapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/item")
public class ItemController {
	
	@GetMapping("/list")
	public String getList() {
		return "admin/item/list";
	}
	
	@GetMapping("/detail")
	public String getDetail() {
		return "admin/item/detail";
	}
	
	@PostMapping("/modify")
	public String postModify() {
		return "admin/item/modify";
	}
	
	@PostMapping("/generate")
	public String postGenerate() {
		return "admin/item/generate";
	}
}
