<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<h1>member - select all</h1>

<c:forEach items="${memberList}" var="row" varStatus="status">
	<p>${row.uid} / ${row.id} / ${row.email}</p>
</c:forEach>

 
<%@ include file="../layout/footer.jsp" %>