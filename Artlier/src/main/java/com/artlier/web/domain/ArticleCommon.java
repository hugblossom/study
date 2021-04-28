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
	private String article_pw;
	private int st;
	private int allow_rep;
	private int view;
	private int good;
	private int bad;
	private Date reg_date;
	private Date mod_date;
}
