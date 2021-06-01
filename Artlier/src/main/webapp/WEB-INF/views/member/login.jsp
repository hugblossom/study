<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../layout/header.jsp" %>

<div class="login_box">
	<div class="inner_box">
	<form id="loginForm" action="/member/login" method="POST">
		<p class="row">
			<span class="title">아이디</span><input type="text" name="id">
		</p>
		<p class="row">
			<span class="title">비밀번호</span><input type="password" name="pw">
		</p>
		<div class="btn_box">
			<input type="submit" class="btn" value="로그인">
		</div>
	</form>
	</div>
</div>

<%@ include file="./../layout/footer.jsp" %>