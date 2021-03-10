<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	${article.uid} <br> ${article.title} <br> ${article.content} <br> ${article.memId} <br> ${article.regDate}
	
	<form id="gbForm" action="/board/goodbad" method="POST">
		<input type="hidden" name="uid" value="${article.uid}">
		<input type="hidden" name="mod" value="">
	</form>
	
	<form id="deleteForm" action="/board/delete" method="POST">
		<input type="hidden" name="uid" value="${article.uid}">
	</form>
	
	<button class="gbBtn" data-val="good">
	 	중요해요(${article.good})
	</button>
	<button class="gbBtn" data-val="bad">
		안중요해요(${article.bad})
	</button>
	<br>
	<a href="/board/update?uid=${article.uid}">수정</a><br>
	<a href="#none" class="deleteBtn" onclick="deleteArticle();">삭제</a><br>
	<br>
	<a href="/board/list">목록으로</a>
	
	<script>
		function getResult() {
			var result = "${result}";
			
			if ( result ) {
				
				if ( result == "1" ) {
					alert("글 수정에 성공하였습니다.");
				} else {
					location.href = "/board/list";
				}
				
			}
		}
		
		getResult();
		
		function gbBtnInit() {
			var btns = document.querySelectorAll(".gbBtn");
			var mod = document.querySelector("input[name=mod]");
			var form = document.querySelector("#gbForm");
			
			for ( var i = 0; i < btns.length; i++ ) {
				btns[i].addEventListener("click", function() {
					var target = this;
					var data = this.getAttribute("data-val");
					mod.value = data;
					form.submit();
					event.preventDefault();
				});
			}
		}
		
		gbBtnInit();
		
		function deleteArticle() {
			var form = document.querySelector("#deleteForm");
			if (confirm("정말로 삭제하시겠습니까?")) {
				form.submit();
			}
		}
		
	</script>
</body>
</html>