package com.artlier.web.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ArticleReply {
	private int uid;
	private String contents;
	private int st;
	private Date red_date;
}
