package com.myapp.web.dto;

import lombok.Data;

@Data
public class TodoDeleteDTO {
	private final int uid;
	private final int seq;
	private final String id;
}
