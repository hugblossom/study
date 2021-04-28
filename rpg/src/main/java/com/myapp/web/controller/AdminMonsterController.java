package com.myapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.web.domain.Monster;
import com.myapp.web.dto.MonsterInsertDTO;
import com.myapp.web.mapper.MonsterMapper;

@Controller
@RequestMapping("/admin/monster")
public class AdminMonsterController {
	
	@Autowired
	private MonsterMapper monsterMapper;
	
	
	@GetMapping("/list")
	public String getList(Model model) {
		
//		if ( !StringUtils.isEmpty(insert) ) {
//			model.addAttribute("insert", insert);
//		}
		
		List<Monster> monsterList = monsterMapper.selectAll();
		model.addAttribute("monsterList", monsterList);
		
		return "admin/monster/list";
	}
	
	@GetMapping("/detail")
	public String getDetail() {
		return "admin/monster/detail";
	}
	
	@PostMapping("/modify")
	public String postModify() {
		return "admin/monster/modify";
	}
	
	@PostMapping("/generate")
	public String postGenerate(MonsterInsertDTO dto) {
		String direction = "redirect:list";
		int result = 0;
		try {

			result = monsterMapper.insert(dto);

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if ( result < 1 ) {
			direction += "?insert=false";
		} else {
			direction += "?insert=true";
		}
		
		monsterMapper.insert(dto);
		
		return direction;
	}
	
	@GetMapping("/generate")
	public String getGenerate() {
		return "admin/monster/generate";
	}
	
}
