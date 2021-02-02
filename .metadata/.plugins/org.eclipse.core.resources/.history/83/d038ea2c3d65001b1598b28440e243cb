<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>article list</div>

<c:forEach items="${articleList}" var="row" varStatus="status">
	<p><a href="/board/detail.do?idx=${row.idx}">${row.idx} / ${row.title} / ${row.writer} / ${row.date}</a></p>
</c:forEach>
<a href="/board/write.do">글쓰기</a>