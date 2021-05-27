package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardCommonReplyDTO {
	
	private int rep_uid;
	private String code;
	private int article_uid;
	private int ancestor_uid;
	private int parent_uid;
	private int seq;
	private String mem_id;
	private String mem_nick;
	private String rep_contents;
	private String reg_date;
	private String mod_date;

}
