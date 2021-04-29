<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common list</h1>

<table>
	<thead>
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</thead>
	<tbody>
	<c:forEach var="row" items="${article_common}" varStatus="i">
	<tr>
		<td>${(i.index - article_count) * -1 }</td>
		<td><a href="/board/common/detail?uid=${row.uid}">${row.title}</a></td>
		<td>${row.nick}</td>
		<td>${row.reg_date}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<p><a href="/board/common/write">글쓰기</a></p>

${pagination}

<%@ include file="./../../layout/footer.jsp" %>