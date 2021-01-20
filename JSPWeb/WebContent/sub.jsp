<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>request userId - <%=request.getParameter("userId")%></p>
	<p>session userId - <%=session.getAttribute("userId")%></p>
	<a href="index.jsp">go index</a>
</body>
</html>