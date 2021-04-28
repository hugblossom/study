<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../layout/header.jsp" %>

<form action="/member/login" method="POST">
	<input type="text" name="id"><br>
	<input type="text" name="pw">
	<input type="submit" value="로그인">
</form>

<%@ include file="./../layout/footer.jsp" %>