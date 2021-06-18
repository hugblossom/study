<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common modify</h1>

<form action="/board/common/modify?code=${board_code}&uid=${article_common.uid}&page=${this_page}" method="POST">
<input type="hidden" name="uid" value="${article_common.uid}">
<input type="hidden" name="id" value="${sessionScope.member_id}">
<input type="hidden" name="allow_rep" value="${article_common.allow_rep}">
<h2><input type="text" name="title" value="${article_common.title}"></h2>
댓글허용<input type="checkbox" name="allowRepOption" ${article_common.allow_rep eq 1 ? "checked" : ""}>
<p>
	작성자 : ${article_common.nick} 
	/ 등록일 : ${article_common.reg_date} 
	<c:if test="${article_common.mod_date ne null}">
	/ 최종수정일 : ${article_common.mod_date}
	</c:if>
</p>
<p><textarea name="contents" id="" cols="30" rows="10">${article_common.contents}</textarea></p>
<input type="password" name="article_pw" value="${article_common.article_pw}"><br>
<input type="submit" value="저장">
</form>
<a href="/board/common/detail?code=${board_code}&uid=${article_common.uid}&page=${this_page}">취소</a>
<a href="/board/common/list?code=${board_code}&page=${this_page}">목록</a>

<script>
	(function() {
		document.querySelector("input[name=allowRepOption]").addEventListener("change", function() {
			var target = event.target;
			var allowRepOption = document.querySelector("input[name=allow_rep]");
				if ( target.checked ) {
					allowRepOption.value = 1;
				} else {
					allowRepOption.value = 0;
				}
		});
		
	})();
</script>

<%@ include file="./../../layout/footer.jsp" %>