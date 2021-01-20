<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("idx", null);
		session.setAttribute("id", null);
		session.setAttribute("email", null);
		session.invalidate();
		
		response.sendRedirect("/index.jsp");
	%>
</body>
</html>