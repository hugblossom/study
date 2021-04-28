package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardCommonWriteDTO {
	private String id;
	private String nick;
	private String title;
	private String article_pw;
	private int allow_rep;
}
