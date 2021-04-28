package com.artlier.web.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class Member {

	private int uid;
	private String id;
	private String pw;
	private String nick;
	private int st;
	private int lv;
	private Date join_date;
	private Date sec_date;
	
}
