<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<h1>member - select</h1>

<p>총 회원수 : ${count} 명 </p>

<p>회원목록</p>
<c:forEach items="${memberList}" var="row" varStatus="status">
	<p>${row.uid} / ${row.id} / ${row.email}</p>
</c:forEach>

<%@ include file="../layout/footer.jsp" %>