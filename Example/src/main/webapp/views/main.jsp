<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	main page
	
	<c:if test="${sessionScope.session_mem_id ne null}">
	<p>${sessionScope.session_mem_id} / ${sessionScope.session_mem_nick} 님 반갑습니다</p>
	</c:if>
</body>
</html>