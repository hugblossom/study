<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/member/join.do" method="POST">
	<p>아이디<input type="text" name="userId" /></p>
	<p>패스워드<input type="password" name="userPasswd" /></p>
	<p>이메일<input type="email" name="userEmail" /></p>
	<input type="submit" value="가입">
</form>

<script type="text/javascript">

	function check() {
		
		var resultCode = "${requestScope.resultCode}";
		
		if ( result == "0000" ) {
			alert("가입에 성공하였습니다");
			window.location.href = "/member/login.do";
		}
		
		if ( result == "0001" ) {
			alert("가입에 실패하였습니다");
		}
		
	}
	
	check();

</script>