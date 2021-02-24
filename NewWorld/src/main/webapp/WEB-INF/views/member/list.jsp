<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Member list
	<ul>
	<c:forEach items="${memberList}" var="row" varStatus="status">
		<li>
			<a href="/member/detail?mem_id=${row.mem_id}" >${row.mem_id} / ${row.mem_email}</a>
		</li>
	</c:forEach>
	</ul>
	
	<div>
		멤버번호 : <input tyoe="text" name="mem_idx" value="" /><input type="button" value="검색" id="getMemberBtn">
		<br>
		<button id="getMemberListBtn" type="button">멤버 리스트 가져오기</button>
	</div>
	
	<script src="/static/js/MemberManipulator.js"></script>
</body>
</html>