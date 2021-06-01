<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common list</h1>
<div class="board_list_box">
<table class="board_common">
	<thead>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${article_common}" varStatus="i">
		<tr>
			<td>${article_count - (this_page - 1) * article_limit - i.index}</td>
			<td>
				<a href="/board/common/detail?code=${board_code}&page=${this_page}&uid=${row.uid}">${row.title}
					<c:if test="${row.allow_rep ne 0}">
					<span class="reply_count">${row.rep_count}</span>
					</c:if>
					<c:if test="${row.article_pw ne null and row.article_pw ne ''}">
					<span class="locked">비밀글</span>
					</c:if>
				</a>
			</td>
			<td>${row.nick}</td>
			<td>${row.reg_date}</td>
			<td>${row.view_count}</td>
			<td>
				${row.like_count}
				<c:if test="${row.liked_mem_id ne null and row.liked_mem_id eq sessionScope.member_id}">
				<span>♥</span>
				</c:if>	
			</td>
		</tr>
	</c:forEach>
	<c:if test="${list_size eq 0}">
		<tr>
			<td colspan="10">게시물이 존재하지 않습니다.</td>
		</tr>
	</c:if>
	</tbody>
</table>
<div class="btn_box">
	<a href="/board/common/write?code=${board_code}" class="btn">글쓰기</a>
</div>

<div class="pagination">
	${pagination}
</div>
</div>

<%@ include file="./../../layout/footer.jsp" %>