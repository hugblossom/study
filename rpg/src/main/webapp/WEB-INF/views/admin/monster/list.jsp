<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../../common/layout/header.jsp" %>

	<h1>monster list</h1>

	<ul>
	<c:forEach items="${monsterList}" var="row" varStatus="status">
		<li>${row.level} / ${row.name} / ${row.info}</li>
	</c:forEach>
	</ul>
	
<%@ include file = "../../common/layout/footer.jsp" %>
	