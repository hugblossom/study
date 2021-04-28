<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common write</h1>

<form action="/board/common/write" method="POST">
	<input type="hidden" name="id" value="${sessionScope.member_id}" />
	<input type="hidden" name="nick" value="${sessionScope.member_nick}" />
	<input type="hidden" name="allow_rep" value="1">
	
	제목<input type="text" name="title"/> 댓글허용<input type="checkbox" name="allowRepOption" checked><br>
	<textarea name="contents" id="" cols="30" rows="10"></textarea><br>
	글 비밀번호 <input type="password" name="article_pw"><br>
	<input type="submit" value="등록">
</form>
<script>
	(function() {
		document.quarySelector("#allowRepOption").addEventListener("change", function() {
			var target = event.target;
			var allowRepOption = document.quarySelector("#allowRepOption");
				if ( target.checked ) {
					allowRepOption.value = 1;
				} else {
					allowRepOption.value = 2;
				}
		});
		
	})();
</script>

<%@ include file="./../../layout/footer.jsp" %>