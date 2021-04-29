<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../layout/header.jsp" %>

<form action="/member/join" method="POST">
	<input type="text" name="id"><br>
	<input type="text" name="nick"><br>
	<input type="password" name="pw"><br>
	<input type="submit" value="가입">
</form>

<a href="/">메인으로</a>

<%@ include file="./../layout/footer.jsp" %>