package com.myapp.web.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
	private int uid;
	private String id;
	private String nick;
	private String passwd;
	private String email;
	private String st;
	private String role;
	private Date regDate;
	private Date modDate;
}
