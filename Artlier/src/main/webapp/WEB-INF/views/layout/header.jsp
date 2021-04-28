<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Artlier</title>
</head>
<body>
	<div>
		<c:if test="${sessionScope.member_id eq null}">
			로그인해주세요 <a href="/member/login">로그인</a> <a href="/member/join">회원가입</a>
		</c:if>
		<c:if test="${sessionScope.member_id ne null}">
			${sessionScope.member_id} 님 반갑습니다 <a href="/member/list">회원리스트</a> <a href="/member/logout">로그아웃</a>
		</c:if>
	</div>
	<div>
		<a href="/board/common/list">게시판</a>
	</div>
