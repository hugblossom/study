package com.artlier.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String getMain(HttpServletRequest request) {
		
//		request.getSession().setAttribute("member_id", "admin");
//		request.getSession().setAttribute("member_nick", "관리자");
		
		return "main";
	}
	
}
