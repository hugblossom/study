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
			${row.art_idx} / ${row.art_title} / ${row.mem_id} / ${row.reg_date}
		</li>
	</c:forEach>
	</ul>
	
</body>
</html>