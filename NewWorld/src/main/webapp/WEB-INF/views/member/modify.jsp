<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<input type="hidden" name="mem_idx" value="1">
		아이디 : <input type="text" name="mem_id" value="stephy" readonly><br>
		닉네임 : <input type="text" name="mem_nick"><br>
		패스워드 : <input type="text" name="mem_passwd"><br>
		이메일 : <input type="text" name="mem_email">
	</div>
	<button id="memberModifyBtn"></button>
	
	<script src="/static/js/MemberManipulator.js"></script>
</body>
</html>