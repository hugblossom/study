package com.myapp.web.domain;

import lombok.Data;

@Data
public class Todo {
	private int uid;
	private int seq;
	private int imp;
	private String contents;
	private String id;
	private String dDay;
}
