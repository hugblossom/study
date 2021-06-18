package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardCommonModifyDTO {
	private String code;
	private int uid;
	private String id;
	private String title;
	private String contents;
	private String article_pw;
	private int st;
	private int allow_rep;
	private String mod_date;
}
