<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ page import="com.vo.Member, com.proc.LoginProc" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId = (String) session.getAttribute("id");
		/*
		if (!"".equals(userId) || userId != null) {
			response.sendRedirect("/index.jsp");
		}
		*/

		String mode		= request.getParameter("mode");
		LoginProc lp	= new LoginProc();
		out.print(mode);
		
		if ("".equals(mode) || mode == null) {
			response.sendRedirect("/signIn.jsp");
		}
		
		if ("idCheck".equals(mode)) {
			String id = request.getParameter("userId");
			Member member = new Member(id);
			
			if (lp.checkId(member)) {
				session.setAttribute("resultCode", "0001"); // 아이디 중복
			} else {
				session.setAttribute("resultCode", "0000"); // 사용가능
			}
			
			session.setAttribute("mode", "idCheck");
			response.sendRedirect("/signIn.jsp");
		} else if ("signIn".equals(mode)) {
			String id		= request.getParameter("userId");
			String pw		= request.getParameter("userPw");
			String email	= request.getParameter("userEmail");
			Member member	= new Member(id, pw, email);
			
			if (lp.setMember(member)) {
				session.setAttribute("resultCode", "0000"); // 성공
			} else {
				session.setAttribute("resultCode", "0001"); // 실패
			}
			
			session.setAttribute("mode", "signIn");
			response.sendRedirect("/signIn.jsp");
		}
		
	%>
</body>
</html>