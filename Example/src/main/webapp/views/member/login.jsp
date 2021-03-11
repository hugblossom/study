<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Member login
	
	<form action="/member/login" method="POST">
		아이디 <input type="text" name="id"><br>
		비번 <input type="text" name="passwd"><br>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>