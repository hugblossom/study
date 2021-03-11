package com.myapp.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Member {
	private int uid;
	private String id;
	private String nick;
	private String passwd;
	private String passwdConfirm;
	private String email;
	private String st;
	private String role;
	private Date regDate;
	private Date modDate;
	
	//addon
	private int exp;
	private int lv;
	private int pt;
	private int cash;
	
	public boolean validate() {
		boolean result = true;
		
		if ( StringUtils.isEmpty(id) ) {
			result = false;
		}
		
			//비거나 null이면 true
		if ( id.length() < 5 || id.length() > 15 ) {
			result = false;
		}
		
		if ( StringUtils.isEmpty(passwd) ) {
			result = false;
		}
		
		if ( passwd.length() < 5 || passwd.length() > 15 ) {
			result = false;
		}
		
		if ( !passwdConfirm.equals(passwd) ) {
			result = false;
		}
		
		if ( passwd.contains(id) ) {
			result = false;
		}
		
		return result;
	}
}
