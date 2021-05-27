package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardCommonWriteDTO {
	private String id;
	private String code;
	private String nick;
	private String title;
	private String contents;
	private String articlePw;
	private int allowRep;
}
