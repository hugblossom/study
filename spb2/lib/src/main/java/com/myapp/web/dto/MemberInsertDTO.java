package com.myapp.web.dto;

import lombok.Data;

@Data
public class MemberInsertDTO {
	private String id;
	private String passwd;
	private String nick;
	private String email;
}
