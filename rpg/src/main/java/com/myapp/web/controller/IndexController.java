package com.myapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping({"/", "/index", "/main"})
	public String index() {
		return "index";
	}
}
