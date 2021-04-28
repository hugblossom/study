<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../../layout/header.jsp" %>

<h1>board common detail</h1>

<h2>${article_common.title}</h2>
<p>
	작성자 : ${article_common.nick} 
	/ 등록일 : ${article_common.reg_date} 
	<c:if test="${article_common.mod_date ne null}">
	/ 최종수정일 : ${article_common.mod_date}
	</c:if>
</p>
<p><textarea name="" id="" cols="30" rows="10" readonly>${article_common.contents}</textarea></p>

<a href="/board/common/modify?uid=${article_common.uid}">수정</a>
<a href="/board/common/list">목록</a>

<%@ include file="./../../layout/footer.jsp" %>