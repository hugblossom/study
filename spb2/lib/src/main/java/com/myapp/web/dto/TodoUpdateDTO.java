package com.myapp.web.dto;

import lombok.Data;

@Data
public class TodoUpdateDTO {
	private final int uid;
	private String id;
	private final int seq;
	private int imp;
	private String contents;
	private String dDay;
}
