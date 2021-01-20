package com.vo;

public class Member {
	private String idx;
	private String id;
	private String passwd;
	private String email;
	
	public Member() {}
	
	public Member(String id) {
		this.id = id;
	}
	
	public Member(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}
	
	public Member(String id, String passwd, String email) {
		this.id = id;
		this.passwd = passwd;
		this.email = email;
	}

	public Member(String idx, String id, String passwd, String email) {
		this.idx = idx;
		this.id = id;
		this.passwd = passwd;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
