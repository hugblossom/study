package com.artlier.web.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardCommonModifyDTO {
	private int uid;
	private String title;
	private String contents;
	private String articlePw;
	private int st;
	private int allowRep;
	private String modDate;
}
