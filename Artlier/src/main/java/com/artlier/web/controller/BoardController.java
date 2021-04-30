package com.artlier.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artlier.web.domain.ArticleCommon;
import com.artlier.web.dto.BoardCommonModifyDTO;
import com.artlier.web.dto.BoardCommonWriteDTO;
import com.artlier.web.dto.PaginationDTO;
import com.artlier.web.mapper.BoardMapper;
import com.artlier.web.util.Pagination;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@GetMapping("/common/list")
	public String getCommonList(@RequestParam int page, Model model, HttpServletRequest request) {
		
		List<ArticleCommon> acList = new ArrayList<>();
		String uri = request.getRequestURI();
		int totalCount = 0;
		try {
			totalCount = boardMapper.countCommonList();
			
			Pagination pagination = new Pagination(totalCount, 10, 10, page, uri);
			int pageMin = pagination.getPageMin();
			int pageMax = pagination.getPageMax();
			String paging = pagination.buildPagination();
			
			System.out.println(paging);
			
			model.addAttribute("pagination", paging);
			
			PaginationDTO dto = new PaginationDTO();
			dto.setPageMin(pageMin);
			dto.setPageMax(pageMax);
			
			acList = boardMapper.selectCommonListByPage(dto);
			
			if ( !ObjectUtils.isEmpty(acList) ) {
				
				model.addAttribute("article_common", acList);
				model.addAttribute("article_count", totalCount);
				
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
		
		return "redirect:/board/common/list?page=1";
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
	public String postCommonModify(@RequestParam String uid, BoardCommonModifyDTO dto) {
		
		try {
		
			int result = boardMapper.boardCommonModify(dto);
			
			if ( result == 0 ) {
				
				throw new RuntimeException("글 수정 실패");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return "redirect:/board/common/detail?uid=" + uid;
	}
}
