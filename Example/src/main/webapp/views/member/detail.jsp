<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member detail</h1>
	<jsp:include page="/views/layout/nav.jsp"></jsp:include>
	
	<p>
		아이디 : ${member.mem_id}
	</p>
	<p>
		닉네임 : ${member.mem_nick}
	</p>
	<p>
		이메일 : ${member.mem_email}
	</p>
	<p>
		가입일 : ${member.reg_date}
	</p>
	<p>
	<c:choose>
		<c:when test="${member.mem_st eq 0}">
			탈퇴
		</c:when>
		<c:when test="${member.mem_st eq 1}">
			정상
		</c:when>
		<c:when test="${member.mem_st eq 2}">
			정지
		</c:when>
		<c:otherwise>
			휴면
		</c:otherwise>
	</c:choose>
	</p>
	
	<br>
	
	<a href="/member/list">리스트로 돌아가기</a>
</body>
</html>