<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>article detail</div>

	<h3>${article.title}</h3>
	<p>${article.contents}</p>
	<p>${article.writer} / ${article.date}</p>

<a href="/board/modify.do?idx=${article.idx}">수정</a>
<a href="/board/list.do">목록으로</a>
<c:if test="${sessionScope.member.id eq article.writer}">
<form action="/board/delete.do" method="POST">
	<input type="hidden" name="idx" value="${article.idx}" />
	<input type="submit" value="삭제">
</form>
</c:if>