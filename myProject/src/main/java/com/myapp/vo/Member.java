package com.myapp.vo;

public class Member {
	
	private int idx;
	private String id;
	private String passwd;
	private String email;
	
	public Member() { super(); } // super 생략가능
	
	public Member(int idx, String id, String passwd, String email) {
		super();
		this.idx = idx;
		this.id = id;
		this.passwd = passwd;
		this.email = email;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
