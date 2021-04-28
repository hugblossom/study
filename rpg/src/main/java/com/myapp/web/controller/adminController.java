package com.myapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin", "/adm"})
public class adminController {
	
	@GetMapping({"/", "/index", "/main"})
	public String getIndex() {
		return "admin/index";
	}
	
	@GetMapping({"/login"})
	public String getLogin() {
		return "admin/login";
	}
	
	@PostMapping
	public String postLogin() {
		return "admin/index";
	}
	
}
