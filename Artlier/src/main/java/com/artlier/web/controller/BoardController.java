package com.artlier.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artlier.web.domain.ArticleCommon;
import com.artlier.web.dto.BoardCommonWriteDTO;
import com.artlier.web.mapper.BoardMapper;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@GetMapping("/common/list")
	public String getCommonList(HttpServletRequest request) {
		
		List<ArticleCommon> acList = new ArrayList<>();
		
		try {
			
			acList = boardMapper.selectCommonList();
			
			if ( !ObjectUtils.isEmpty(acList) ) {
				
				request.setAttribute("article_common", acList);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/board/common/list";
	}
	
	@GetMapping("/common/detail")
	public String getCommonDetail(@RequestParam int uid, HttpServletRequest request) {
		
		ArticleCommon ac = new ArticleCommon();
	
		try {
			
			ac = boardMapper.selectCommonListByUid(uid);
			
			if ( !ObjectUtils.isEmpty(ac) ) {
				
				request.setAttribute("article_common", ac);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/board/common/detail";
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
		
		return "redirect:/board/common/list";
	}
	
	@GetMapping("/common/modify")
	public String getCommonModify(@RequestParam int uid, HttpServletRequest request) {
		
		ArticleCommon ac = new ArticleCommon();
		
		try {
			ac = boardMapper.selectCommonListByUid(uid);
			
			if ( !ObjectUtils.isEmpty(ac) ) {
				
				request.setAttribute("article_common", ac);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/board/common/modify";
	}
	
	@PostMapping("/common/modify")
	public String postCommonModify(@RequestParam String uid, BoardCommonWriteDTO dto) {
		
		try {
		
			int result = boardMapper.boardCommonModify(dto);
			
			if ( result == 0 ) {
				
				throw new RuntimeException("글 수정 실패");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return "redirect:/board/common/detail?" + uid;
	}
}
