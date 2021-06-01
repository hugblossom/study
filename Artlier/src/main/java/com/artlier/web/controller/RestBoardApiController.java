package com.artlier.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.artlier.web.dto.BoardCommonHistoryDTO;
import com.artlier.web.mapper.BoardMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestBoardApiController {

	@Autowired
	private BoardMapper boardMapper;
	
	@PostMapping("/board/common/like")
	public @ResponseBody String postLike(@RequestBody BoardCommonHistoryDTO jsonDTO, HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();

		String memId = "GUEST";
		String ip = request.getRemoteAddr();
		String action = "LIKE";
		boolean liked = true;
		String result = "";
	
		try {
			
			BoardCommonHistoryDTO dto = new BoardCommonHistoryDTO();
			
			if ( StringUtils.hasText(jsonDTO.getMem_id()) ) {
				memId = jsonDTO.getMem_id();
			}
			
			dto.setUid(jsonDTO.getUid());
			dto.setCode(jsonDTO.getCode());
			dto.setAction(action);
			dto.setMem_id(jsonDTO.getMem_id());
			dto.setIp(ip);
			
			int likeCount = boardMapper.selectBoardHistory(dto).getUser_like_count();
			if ( likeCount == 0 ) {
				liked = false;
			}
			
			if ( liked ) {
				boardMapper.deleteBoardLikeHistory(dto);
				likeCount = 0;
			} else {
				boardMapper.insertBoardHistory(dto);
				likeCount = 1;
			}
			
			result = Integer.toString(likeCount);
		
		} catch ( Exception e) {
			
		}
		return result;
	}
	
}
