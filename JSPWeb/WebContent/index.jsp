<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.ArrayList, java.util.List" %>
<%@ page import="com.proc.MemberProc, com.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Member m = new Member("아무아이디");
		out.print(m.getId());
	
		String userId = (String) session.getAttribute("id");
		if ("".equals(userId) || userId == null) {
	%>
	
	
	
		<form action="/loginProc.jsp" method="POST">
			<p>아이디</p>
			<input type="text" id="userId" name="userId" />
			<p>패스워드</p>
			<input type="text" id="userPw" name="userPw" />
			<input type="submit" value="로그인"/>
		</form>
		<a href="/signIn.jsp">회원가입</a>
		
		
		
		
	<%
		} else {
	%>
	
	
	
		<p>반갑습니다 <%=session.getAttribute("id")%>(<%=session.getAttribute("email") %>)</p>
		<a href="/logoutProc.jsp">로그아웃</a>
		
		
		
	<%
		}
	%>
	<a href="/sub.jsp">go sub</a>
</body>
</html>