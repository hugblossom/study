<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>article list</div>

<c:forEach items="${articleList}" var="row" varStatus="status">
	<p><a href="/board/detail.do?idx=${row.idx}">${status.count + (pageCnt * (pageNum - 1)) } / ${row.title} / ${row.writer} / ${row.date}</a></p>
</c:forEach>

<c:forEach var="row" begin="1" end="${pages}">
	<a href="/board/list.do?pageNum=${row}">${row}</a>
</c:forEach>
<br>
<a href="/board/write.do">글쓰기</a>