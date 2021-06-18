package com.artlier.web.dto;

import lombok.Data;

@Data
public class BoardToken {

	private String code;
	private int uid;
	private String mem_id;
	private String cert_date;
	private boolean token_expired;
	
}
