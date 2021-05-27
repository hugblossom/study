<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common detail</h1>
<div class="article_box">
	<h2 class="article_title">${article_common.title}</h2>
	<div class="article_info">
		<ul class="info_list">
			<li>
				<span class="title">작성자</span>
				<span class="data">${article_common.nick}</span>
			</li>
			<li>
				<span class="title">등록일</span>
				<span class="data">${article_common.reg_date}</span>
			</li>
			<li>
				<span class="title">조회수</span>
				<span class="data">${article_common.view_count}</span>
			</li>
			<c:if test="${article_common.mod_date ne null}">
			<li>
				<span class="title">최종수정일</span>
				<span class="data">${article_common.mod_date}</span>
			</li>			
			</c:if>
		</ul>
	</div>
	<div class="article_contents">
		${article_common.contents}
	</div>
	<div class="article_like">
		<form action="/board/common/like?code=${board_code}&uid=${article_common.uid}&page=${this_page}" method="POST">		
			<input type="submit" class="btn btn_like ${user_like_count ne 0 ? 'on' : ''} ${sessionScope.member_id ne null and sessionScope.member_id eq article_common.id ? 'locked' : ''}" value="♥ ${article_common.like_count}">
		</form>
	</div>
	<form id="deleteForm" action="/board/common/delete?&uid=${article_common.uid}&page=${this_page}" method="POST">
		<input type="hidden" name="code" value="${board_code}">
		<input type="hidden" name="uid" value="${article_common.uid}">
		<input type="hidden" name="id" value="${sessionScope.member_id}">
	</form>
	<div class="btn_box">
		<c:if test="${sessionScope.member_id eq article_common.id}">
		<a href="/board/common/modify?code=${board_code}&uid=${article_common.uid}&page=${this_page}">수정</a>
		<a href="#none" onclick="doDelete()">삭제</a>
		</c:if>
		<a href="/board/common/list?code=${board_code}&page=${this_page}">목록</a>
	</div>
</div>
<script>
	function doDelete() {
		event.preventDefault();
		var thisConfirm = confirm("정말 삭제하시겠습니까?");
		if ( thisConfirm ) {
			document.querySelector('#deleteForm').submit();
		}
	}
</script>

<div class="reply_box">
	<div class="write_box">
	<c:choose>
		<c:when test="${article_common.allow_rep eq 1}">
			<c:choose>
				<c:when test="${sessionScope.member_id ne null}">
					<form action="/board/common/reply/write?uid=${article_common.uid}&page=${this_page}" method="POST">
						<input type="hidden" name="code" value="${board_code}">
						<input type="hidden" name="article_uid" value="${article_common.uid}">
						<input type="hidden" name="mem_id" value="${sessionScope.member_id}">
						<input type="hidden" name="mem_nick" value="${sessionScope.member_nick}">
						<span class="title">댓글쓰기</span>
						<textarea name="rep_contents" id="" cols="100" rows="5"></textarea>
						<div class="btn_box">
							<input type="submit" class="btn" value="등록">
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<p>댓글을 작성하려면 <a href="/member/login">로그인</a> 해주세요</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>댓글이 허용되지 않은 글입니다.</p>
		</c:otherwise>
	</c:choose>
	</div>
	<c:if test="${article_common.allow_rep eq 1}">
	<ul class="reply_list">
	<c:forEach items="${replyList}" var="row">
		<li class="${row.parent_uid ne 0 ? 'children' : ''}">
			<div class="reply_view">
				<form class="reply_modify" method="POST">
				<input type="hidden" name="rep_uid" value="${row.rep_uid}">
				<input type="hidden" name="code" value="${board_code}">
				<input type="hidden" name="article_uid" value="${row.article_uid}">
				<input type="hidden" name="parent_uid" value="${row.parent_uid}">
				<input type="hidden" name="mem_id" value="${row.mem_id}">
				<input type="hidden" name="article_uid" value="${row.article_uid}">
				<div class="reply_info">
					<span class="reply_name">${row.mem_nick}</span><span class="reply_date">${row.reg_date}</span>
				</div>
				<div class="reply_contents">
					<div class="view_box">
						${row.rep_contents}
						<c:if test="${row.mod_date ne null}">
							<br>(${row.mod_date} 마지막 수정)
						</c:if>
					</div>
					<div class="modify_box">
						<textarea name="rep_contents" id="" class="reply_contents" cols="100" rows="5">${row.rep_contents}</textarea>
					</div>
					<c:if test="${sessionScope.member_id ne null}">
					<div class="btn_box">
						<c:if test="${row.mem_id eq sessionScope.member_id}">
						<button type="button" class="btn btn_submit btn_save" data-action="modify">변경</button>
						<button type="button" class="btn btn_submit btn_delete" data-action="delete">삭제</button>
						<button type="button" class="btn btn_toggle" data-action="modify">수정</button>
						</c:if>
						<button type="button" class="btn btn_toggle" data-action="reply">댓글</button>
					</div>
					</c:if>
				</div>
				</form>
				<div class="write_box">
					<form action="/board/common/reply/write?uid=${article_common.uid}&page=${this_page}" method="POST">
						<input type="hidden" name="code" value="${board_code}">
						<input type="hidden" name="article_uid" value="${article_common.uid}">
						<input type="hidden" name="ancestor_uid" value="${row.parent_uid eq 0 ? row.rep_uid : row.parent_uid}">
						<input type="hidden" name="parent_uid" value="${row.rep_uid}">
						<input type="hidden" name="seq" value="${row.seq + 1}">
						<input type="hidden" name="mem_id" value="${sessionScope.member_id}">
						<input type="hidden" name="mem_nick" value="${sessionScope.member_nick}">
						<span class="title">댓글쓰기</span>
						<textarea name="rep_contents" id="" cols="100" rows="5"></textarea>
						<div class="btn_box">
							<input type="submit" class="btn" value="등록">
						</div>
					</form>
				</div>
			</div>
		</li>
	</c:forEach>
	<c:if test="${replyList eq null}">
		<li>
			<div class="reply_view">
				<div class="reply_contents">
					<div class="view_box">
						<p>등록된 댓글이 없습니다</p>
					</div>
				</div>
			</div>
		</li>	
	</c:if>
	</ul>
	</c:if>
</div>
<script>
	$('.reply_box .btn_submit').click(function(e) {
		
		var $this = $(this);
		var thisAction = $this.data("action");
		var thisConfirm = "";
		
		if ( thisAction == "modify" ) thisConfirm = confirm("정말 수정하시겠습니까?")
		if ( thisAction == "delete" ) thisConfirm = confirm("정말 삭제하시겠습니까?")
		
		if ( thisConfirm ) $this.parents('.reply_modify').attr("action", "/board/common/reply/" + thisAction + "?uid=${article_common.uid}&page=${this_page}").submit();
		
	});
</script>

<%@ include file="./../../layout/footer.jsp" %>