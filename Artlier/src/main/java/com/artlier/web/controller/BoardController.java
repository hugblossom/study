package com.artlier.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artlier.web.dto.BoardCommonWriteDTO;
import com.artlier.web.mapper.BoardMapper;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/common/list")
	public String getCommonList() {
		
		return "/board/common/list";
	}
	
	@GetMapping("/common/write")
	public String getCommonWrite(HttpServletRequest request) {
		
		
		return "/board/common/write";
	}
	
	@PostMapping("/common/write")
	public String postCommonWrite(BoardCommonWriteDTO dto) {
		
		try {
			boardMapper.boardCommonWrite(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/common/list";
	}

}
