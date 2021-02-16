package com.myapp.exception;

public class MemberJoinFailedException extends RuntimeException {
	public MemberJoinFailedException(String msg) {
		super(msg);
	}
	
	public MemberJoinFailedException(Exception e) {
		super(e.getMessage());
	}
}
