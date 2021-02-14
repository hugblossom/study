package com.myapp.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
	private String memberIdx;
	private String memberId;
	private String memberPasswd;
	private String memberEmail;
	private String regDate;
	private String modDate;
	
	public String toString() {
		return "id: " + memberId + " / email: " + memberEmail;
		
	}
}
