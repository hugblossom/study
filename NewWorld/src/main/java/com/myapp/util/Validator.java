package com.myapp.util;

public class Validator {
	public boolean isNumberOnly(String value) {
		return value.matches("^[0-9]*$");
	}
	
	public boolean isKoreanOnly(String value) {
		return value.matches("^[가-힣]*$");
	}
	
	public boolean isAlphabetOnly(String value) {
		return value.matches("^[a-zA-Z]*$");
	}
	
	public boolean isAlphabetAndNumber(String value) {
		return value.matches("^[a-zA-Z0-9]*$");
	}
	
	public boolean isNumberFirst(String value) {
		return value.matches("^[0-9]");
	}
	
	public boolean isPhoneNumber(String value) {
		return value.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$");
	}
	
	public boolean isIpAdress(String value) {
		return value.matches("\\d{1,3}\\.\\d{1,3}\\.\\.\\d{1,3}\\.\\d{1,3}");
	}
	
	public boolean isUrl(String value) {
		return value.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
	}
	
	public boolean isIdentifyNumber(String value) {
		return value.matches("\\d{6}\\-[1-4]\\d{6}");
	}
	
	public boolean isEmail(String value) {
		return value.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
	}
	
	public boolean isContainNumber(String value) {
		return value.matches("[0-9]{1,}");
	}
	
	public boolean isContainKorean(String value) {
		return value.matches("[ㄱ-ㅎ가-힣]{1,}");
	}
	
	public boolean isContainSpecialChar(String value) {
		return value.matches("([^\\w ]|[_]){1,}");
	}
	
	public boolean isContainWhiteSpace(String value) {
		return value.matches("[\s]");
	}
}
