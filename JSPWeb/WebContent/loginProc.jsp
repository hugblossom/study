<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ page import="com.proc.LoginProc, com.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String uid = request.getParameter("userId");
		String upw = request.getParameter("userPw");
		
		Member member = new Member(uid, upw);
		
		LoginProc lp = new LoginProc();
		
		try {
			Member cMember = lp.getLogin(member);
			
			session.setAttribute("idx", cMember.getIdx());
			session.setAttribute("id", cMember.getId());
			session.setAttribute("email", cMember.getEmail());
	%>
	
			<jsp:forward page="/index.jsp" />
			
	<%
		} catch (Exception e) {
			out.print("<script>");
			out.print("alert(\"" + e.getMessage() + "\");");
			out.print("window.location.href='/index.jsp';");
			out.print("</script>");
		}
		
	%>
</body>
</html>