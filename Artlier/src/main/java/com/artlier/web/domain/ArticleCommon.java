package com.artlier.web.domain;

import lombok.Data;

@Data
public class ArticleCommon {
	private int uid;
	private String id;
	private String nick;
	private String title;
	private String contents;
	private String article_pw;
	private int st;
	private int allow_rep;
	private int view;
	private int good;
	private int bad;
	private String reg_date;
	private String mod_date;
}
