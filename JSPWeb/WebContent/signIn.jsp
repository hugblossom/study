<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId = (String) session.getAttribute("id");
		
		/* if (!"".equals(userId) || userId != null) {
			response.sendRedirect("/index.jsp");
		} */
	%>
	
	<%
		String mode			= (String) session.getAttribute("mode");
		String resultCode	= (String) session.getAttribute("resultCode");
		
		if ("idCheck".equals(mode)) {
			out.println("<script>");
			out.println("if (0000 == " + resultCode + ") {");
			out.println("alert('사용 가능한 아이디입니다');");
			out.println("} else {");
			out.println("alert('이미 사용중인 아이디입니다');");
			out.println("}");
			out.println("</script>");
		}
		
		if ("signIn".equals(mode)) {
			out.println("<script>");
			out.println("if (0000 == " + resultCode + ") {");
			out.println("alert('회원가입에 성공하였습니다\n로그인해 주세요');");
			out.println("window.location.href='/index.jsp'");
			out.println("} else {");
			out.println("alert('회원가입에 실패하였습니다\n다시 시도해주세요');");
			out.println("window.location.href");
			out.println("}");
			out.println("</script>");
		}
	%>

	<form>
		<p>아이디</p><input id="userId" name="userId" />
		<button onclick="checkId(); event.preventDefault();">아이디중복체크</button>
		<p>패스워드</p><input id="userPw" name="userPw" />
		<p>이메일</p><input id="userEmail" name="userEmail" />
		<button onclick="signInCheck();">가입</button>
	</form>
	
	<script type="text/javascript">
		function checkId() {
			var id = document.querySelector("#userId").value;
			
			if (id == "") {
				alert("아이디를 입력하세요");
				return false;
			}
			
			location.href = "/signInProc.jsp?mode=idCheck&userId=" + id;
		}
		
		function signInCheck() {
			var id = document.querySelector("#userId").value;
			var pw = document.querySelector("#userPw").value;
			var email = document.querySelector("#userEmail").value;
			
			if (id == "") {
				alert("아이디를 입력하세요");
				return false;
			}
			
			if (pw == "") {
				alert("패스워드를 입력하세요");
				return false;
			}
			
			if (email == "") {
				alert("이메일를 입력하세요");
				return false;
			}
			
			location.href = "/signInProc.jsp?mode=signIn&userId=" + userId + "&userPw=" + userPw + "&userEmail=" + userEmail;
		}
	</script>
</body>
</html>