package com.myapp.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoInsertDTO {
	private int imp;
	private String contents;
	private String id;
	private String dDay;
}
