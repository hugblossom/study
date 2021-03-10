<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	글 수정
	
	<form action="/board/update" method="POST">
		<input type="hidden" name="uid" value="${article.uid}">
		글 제목 : <input type="text" name="title" value="${article.title}" placeholder="제목"><br>
		글 내용 :<textarea rows="" cols="" name="content" placeholder="내용">${article.content}</textarea>
		<a href="/board/detail?uid=${article.uid}">취소</a>
		<input type="submit" value="수정">
	</form>
			
</body>
</html>