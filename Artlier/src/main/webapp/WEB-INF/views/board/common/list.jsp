<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common list</h1>

<ul>
	<c:forEach var="row" items="${article_common}">
	<li>
		<a href="/board/common/detail?uid=${row.uid}">${row.nick} / ${row.title} / ${row.reg_date}</a>
	</li>
	</c:forEach>
</ul>

<p><a href="/board/common/write">글쓰기</a></p>

<%@ include file="./../../layout/footer.jsp" %>