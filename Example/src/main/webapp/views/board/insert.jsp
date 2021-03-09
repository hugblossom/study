<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/board/insert" method="POST">
		제목:<input type="text" name="title" placeholder="제목"><br>
		내용:<textarea rows="" cols="" name="content" placeholder="내용">
		</textarea>
		<input type="submit" value="작성">
	</form>
		
</body>
</html>