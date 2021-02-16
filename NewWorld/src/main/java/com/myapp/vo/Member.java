package com.myapp.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.myapp.util.Notification;
import com.myapp.util.Validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
	private int mem_idx;
	private String mem_id;
	private String mem_nick;
	private String mem_passwd;
	private String mem_passwd_confirm;
	private String mem_email;
	private String mem_st;
	private String mem_auth;
	private Date reg_date;
	private Date mod_date;
	
	public Member(int mem_idx, String mem_id, String mem_nick, String mem_passwd, String mem_email, String mem_st,
			String mem_auth, Date reg_date, Date mod_date) {
		super();
		this.mem_idx = mem_idx;
		this.mem_id = mem_id;
		this.mem_nick = mem_nick;
		this.mem_passwd = mem_passwd;
		this.mem_email = mem_email;
		this.mem_st = mem_st;
		this.mem_auth = mem_auth;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
	}
	
	public Notification validateJoin() {
		Notification noti = new Notification();
		Validator validator = new Validator();
		
		if (
			validator.isNumberFirst(mem_id) ||
			!validator.isAlphabetAndNumber(mem_id) ||
			validator.isContainSpecialChar(mem_id) ||
			StringUtils.isEmpty(mem_id) ||
			mem_id.length() < 5 ||
			mem_id.length() > 50
		) {
			noti.put("mem_id", Boolean.FALSE);
		}
		
		if (
			StringUtils.isEmpty(mem_nick) ||
			mem_nick.length() < 2 ||
			mem_nick.length() > 10
		) {
			noti.put("mem_nick", Boolean.FALSE);
		}
		
		if (
			!validator.isContainSpecialChar(mem_passwd) ||
			StringUtils.isEmpty(mem_passwd) ||
			mem_passwd.length() < 8 ||
			mem_passwd.length() > 30 ||
			mem_passwd.contains(mem_id)
		) {
			noti.put("mem_passwd", Boolean.FALSE);
		}
		
		if (!mem_passwd_confirm.equals(mem_passwd)) {
			noti.put("mem_passwd_confirm", Boolean.FALSE);
		}
		
		if (
			StringUtils.isEmpty(mem_email) ||
			!validator.isEmail(mem_email)
		) {
			noti.put("mem_email", Boolean.FALSE);
		}
		
		return noti;
	}
	
	
}
