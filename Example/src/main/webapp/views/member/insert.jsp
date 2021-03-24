<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member insert</h1>
	<jsp:include page="/views/layout/nav.jsp"></jsp:include>
	
	<form action="" method="POST">
		아이디 <input type="text" name="mem_id"> <button id="idCheckBtn">중복확인</button><br>
		닉네임 <input type="text" name="mem_nick"><br>
		비번 <input type="text" name="mem_passwd"><br>
		비번확인 <input type="text" name="mem_passwd_confirm"><br>
		이메일 <input type="text" name="mem_email">
		<input type="submit" value="가입">
	</form>
	
	<script src="/static/js/MemberManipulator.js"></script>
</body>
</html>