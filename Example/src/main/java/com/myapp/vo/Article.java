package com.myapp.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Article {
	private int uid;
	private String kind;
	private String title;
	private String content;
	private String memId;
	private int good;
	private int bad;
	private String st;
	private String passwd;
	private Date regDate;
	private Date modDate;
}
