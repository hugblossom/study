<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Board list
	<ul>
	<c:forEach items="${articleList}" var="row" varStatus="status">
		<li>
			<a href="/board/detail?uid=${row.uid}"> ${row.uid}  / ${row.title} / ${row.memId} / ${row.regDate}</a>
		</li>
	</c:forEach>
	</ul>
	
	<script>
		function getResult() {
			var result = "${result}";
			
			if ( result ) {
				alert("글쓰기에 성공하였습니다.");
			}
		}
		
		getResult();
	</script>
</body>
</html>