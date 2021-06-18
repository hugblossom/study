package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardCommonHistoryDTO {
	
	private int uid;
	private String code;
	private String action;
	private String mem_id;
	private String ip;
	
	private int user_view_count;
	private int user_like_count;
	
}
