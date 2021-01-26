<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form action="/member/login.do" method="POST">
	<p>아이디<input type="text" name="userId" /></p>
	<p>패스워드<input type="password" name="userPasswd" /></p>
	<input type="submit" value="로그인">
</form>