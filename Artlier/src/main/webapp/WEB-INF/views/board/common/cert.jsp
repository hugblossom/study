<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common certification</h1>
<div class="login_box">
	<div class="inner_box">
	<form id="certForm" action="/board/common/cert?code=${board_code}&uid=${article_uid}&page=${this_page}" method="POST">
		<p class="row">
			<span class="title">게시글 비밀번호</span>	
			<input type="password" name="article_pw">
		</p>
		<div class="btn_box">
			<input type="submit" class="btn" value="로그인">
			<a href="/board/common/list?code=${board_code}&page=${this_page}" class="btn">돌아가기</a>
		</div>
	</form>
	</div>
</div>

<%@ include file="./../../layout/footer.jsp" %>