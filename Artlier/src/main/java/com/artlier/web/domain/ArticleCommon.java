package com.artlier.web.domain;

import lombok.Data;

@Data
public class ArticleCommon {
	private int uid;
	private String code;
	private String id;
	private String nick;
	private String title;
	private String contents;
	private String article_pw;
	private int st;
	private int allow_rep;
	private String reg_date;
	private String mod_date;
	
	private int view_count;
	private int like_count;
	private String liked_mem_id;
	
	private int rep_count;
}
