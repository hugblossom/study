package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardCommonModifyDTO {
	private String code;
	private int uid;
	private String id;
	private String title;
	private String contents;
	private String articlePw;
	private int st;
	private int allowRep;
	private String modDate;
}
