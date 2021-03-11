<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Member insert
	
	<form action="/member/join" method="POST">
		아이디 <input type="text" name="id"><br>
		닉네임 <input type="text" name="nick"><br>
		비번 <input type="text" name="passwd"><br>
		비번확인 <input type="text" name="passwd_confirm"><br>
		이메일 <input type="text" name="email">
		<input type="submit" value="가입">
	</form>
	
	<script>
		function joinCheck() {
			var result = "${result}";
			var msg = "";
			var loca = "/main";
			
			if ( result == "0000" ) {
				msg = "가입에 상공하였습니다.\n로그인 페이지로 이동합니다";
				loca = "/member/login";
			} else if ( result == "0001" ) {
				msg = "값이 올바르지 않습니다.";
				loca = "/member/join";
			} else if ( result == "0002" ) {
				msg = "서버에 문제가 있습니다. 잠시 후 다시 시도해 주세요.";
				loca = "/member/join";
			} else {
				msg = "올바르지 않은 접근입니다.";
				loca = "/main";
			}
			alert(msg);
			location.href = loca;
		}
	</script>
</body>
</html>