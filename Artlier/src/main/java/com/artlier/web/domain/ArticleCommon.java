package com.artlier.web.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ArticleCommon {
	private int uid;
	private String id;
	private String nick;
	private String title;
	private String contents;
	private int articlePw;
	private int st;
	private int allowRep;
	private int view;
	private int good;
	private int bad;
	private Date regDate;
	private Date modDate;
}
