package com.myapp.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Article {
	private int art_idx;
	private String art_title;
	private String art_content;
	private String mem_id;
	private int art_good;
	private int art_bad;
	private String art_st;
	private String art_passwd;
	private Date reg_date;
	private Date mod_date;
}
