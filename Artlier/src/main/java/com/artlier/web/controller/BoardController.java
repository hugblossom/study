package com.artlier.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.artlier.web.dto.BoardCommonReplyDTO;
import com.artlier.web.dto.BoardCommonWriteDTO;
import com.artlier.web.dto.BoardCommonHistoryDTO;
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
	public String getCommonList(@RequestParam String code, @RequestParam int page, Model model, HttpServletRequest request) {
		
		List<ArticleCommon> acList = new ArrayList<>();
		int totalCount = 0;
		
		try {
			
			if ( !ObjectUtils.isEmpty(acList) ) {
				
				String notFound = "게시물이 존재하지 않습니다.";
				
				model.addAttribute("article_common", notFound);
				
			}
				
				totalCount = boardMapper.countCommonList(code);
				
				Pagination pagination = new Pagination(code, totalCount, 10, 5, page);
				int pageMin = pagination.getArticleStart(page);
				int articles = pagination.getArticleLimit();
				String paging = pagination.buildPagination();
				
				model.addAttribute("pagination", paging);
				
				PaginationDTO dto = new PaginationDTO();
				dto.setCode(code);
				dto.setPageMin(pageMin);
				dto.setArticles(articles);
				
				acList = boardMapper.selectCommonListByPage(dto);
				model.addAttribute("article_common", acList);
				model.addAttribute("article_count", totalCount);
				model.addAttribute("this_page", page);
				model.addAttribute("article_limit", articles);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("board_code", code);
		
		return "/board/common/list";
	}
	
	@GetMapping("/common/detail")
	public String getCommonDetail(@RequestParam String code, @RequestParam int page, @RequestParam int uid, HttpServletRequest request, Model model) {
		
		ArticleCommon ac = null;
		String memId = "GUEST";
		String ip = request.getRemoteAddr();
		String action = "VIEW";
		int viewCount = 0;
		int likeCount = 0;
	
		try {
			
			BoardCommonHistoryDTO dto = new BoardCommonHistoryDTO();
			
			if ( !ObjectUtils.isEmpty(request.getSession().getAttribute("member_id")) ) {
				memId = (String) request.getSession().getAttribute("member_id");
			}
			dto.setMem_id(memId);
			dto.setUid(uid);
			dto.setCode(code);
			dto.setAction(action);
			dto.setIp(ip);
						
			BoardCommonHistoryDTO resultDTO = boardMapper.selectBoardHistory(dto);
			
			if ( !ObjectUtils.isEmpty(resultDTO) ) {
				
				viewCount = resultDTO.getUser_view_count();
				likeCount = resultDTO.getUser_like_count();
				
			}
	
			if ( !ObjectUtils.isEmpty(resultDTO) && resultDTO.getUser_view_count() == 0 ) {
				
				boardMapper.insertBoardHistory(dto);
			
			}
			
			ArticleCommon uidAndCodeDTO = new ArticleCommon();
			uidAndCodeDTO.setUid(uid);
			uidAndCodeDTO.setCode(code);
			
			ac = boardMapper.selectCommonListByUid(uidAndCodeDTO);
			
			if ( !ObjectUtils.isEmpty(ac) ) {
				model.addAttribute("board_code", code);
				model.addAttribute("article_common", ac);
				model.addAttribute("this_page", page);
			}
			
			BoardCommonReplyDTO bcrSetDTO = new BoardCommonReplyDTO();
			bcrSetDTO.setArticle_uid(uid);
			bcrSetDTO.setCode(code);
			
			List<BoardCommonReplyDTO> bcrGetDTO = boardMapper.selectReplyListByUidAndSeq(bcrSetDTO);
			
			System.out.println(bcrGetDTO);
			
			if ( !ObjectUtils.isEmpty(bcrGetDTO) ) {
				model.addAttribute("replyList", bcrGetDTO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("user_view_count", viewCount);
		model.addAttribute("user_like_count", likeCount);
		
		return "/board/common/detail";
	}
	
	@GetMapping("/common/write")
	public String getCommonWrite(@RequestParam String code, HttpServletRequest request, Model model) {
		
		String ip = request.getRemoteAddr();
		
		model.addAttribute("user_ip", ip);
		model.addAttribute("board_code", code);
		
		return "/board/common/write";
	}
	
	@PostMapping("/common/write")
	public String postCommonWrite(@RequestParam String code, BoardCommonWriteDTO dto) {
		
		String resultUid = "&uid=";
		
		String direction = "redirect:/board/common/list?code=" + code + "&page=1";
				
		try {
			
			boardMapper.boardCommonWrite(dto);
			int temp = boardMapper.selectLastInsertId(dto);
			
			if ( !ObjectUtils.isEmpty(temp) ) {
				resultUid += Integer.toString(temp);
			}
			
			direction = "redirect:/board/common/detail?code=" + code + "&page=1" + resultUid;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return direction;
	}
	
	@GetMapping("/common/modify")
	public String getCommonModify(@RequestParam String code, @RequestParam int uid, @RequestParam int page, Model model) {
		
		ArticleCommon ac = new ArticleCommon();
		ArticleCommon uidAndCode = new ArticleCommon();
		uidAndCode.setCode(code);
		uidAndCode.setUid(uid);
		
		try {
			ac = boardMapper.selectCommonListByUid(uidAndCode);
			
			if ( !ObjectUtils.isEmpty(ac) ) {
				
				model.addAttribute("article_common", ac);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("board_code", code);
		model.addAttribute("this_page", page);
		
		return "/board/common/modify";
	}
	
	@PostMapping("/common/modify")
	public String postCommonModify(@RequestParam String code, @RequestParam int uid, @RequestParam int page, BoardCommonModifyDTO dto) {
		
		try {
		
			int result = boardMapper.boardCommonModify(dto);
			
			if ( result == 0 ) {
				
				throw new RuntimeException("글 수정 실패");
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "redirect:/board/common/detail?code=" + code + "&uid=" + uid + "&page=" + page;
	}
	
	@PostMapping("/common/delete")
	public String postDelete(@RequestParam int page, BoardCommonModifyDTO dto, Model model) {
		
		String code = dto.getCode();
		int uid = dto.getUid();
		String direction = "redirect:/board/common/detail?code=" + code + "&page=" + page + "&uid=" + uid;
		
		try {
			
			System.out.println(dto);
			int result = boardMapper.boardCommonDelete(dto);
			
			if ( result < 1 ) {
				
				throw new RuntimeException("article delete failed");
				
			}
			
			direction ="redirect:/board/common/list?code=" + code + "&page=" + page;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return direction;
	}
	
	@PostMapping("/common/like")
	public String postLike(@RequestParam int uid, @RequestParam String code, @RequestParam int page, HttpServletRequest request) {
		
		String memId = "GUEST";
		String ip = request.getRemoteAddr();
		String action = "LIKE";
		boolean liked = true;
	
		try {
			
			BoardCommonHistoryDTO dto = new BoardCommonHistoryDTO();
			
			if ( !ObjectUtils.isEmpty(request.getSession().getAttribute("member_id")) ) {
				memId = (String) request.getSession().getAttribute("member_id");
			}
			
			dto.setUid(uid);
			dto.setCode(code);
			dto.setAction(action);
			dto.setMem_id(memId);
			dto.setIp(ip);
			
			int likeCount = boardMapper.selectBoardHistory(dto).getUser_like_count();
			if ( likeCount == 0 ) {
				liked = false;
			}
			
			if ( liked ) {
				boardMapper.deleteBoardLikeHistory(dto);
			} else {
				boardMapper.insertBoardHistory(dto);
			}
		
		} catch ( Exception e) {
			
		}
		return "redirect:/board/common/detail?code=" + code + "&uid=" + uid + "&page=" + page;
	}
	
	@PostMapping("/common/reply/write")
	public String postReplyWrite(@RequestParam int uid, @RequestParam String code, @RequestParam int page, BoardCommonReplyDTO dto, Model model) {
		
		try {
			
			int result = boardMapper.insertBoardReply(dto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/common/detail?code=" + code + "&uid=" + uid + "&page=" + page;
	}
	
	@PostMapping("/common/reply/modify")
	public String postReplyModify(@RequestParam int uid, @RequestParam String code, @RequestParam int page, BoardCommonReplyDTO dto, Model model) {
		
		try {
			
			int result = boardMapper.boardReplyModify(dto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/common/detail?code=" + code + "&uid=" + uid + "&page=" + page;
	}
	
	@PostMapping("/common/reply/delete")
	public String postReplyDelete(@RequestParam int uid, @RequestParam String code, @RequestParam int page, BoardCommonReplyDTO dto, Model model) {
		
		try {
			
			int result = boardMapper.boardReplyDelete(dto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/common/detail?code=" + code + "&uid=" + uid + "&page=" + page;
	}
	
}
