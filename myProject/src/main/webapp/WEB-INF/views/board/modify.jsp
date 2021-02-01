<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>article modify</div>

<form action="/board/modify.do" method="POST">
	<input type="hidden" name="idx" value="${article.idx}">
	<p>글제목</p><input type="text" name="title" value="${article.title}" />
	<p>내용</p><textarea name="contents">${article.contents}</textarea>
	<input type="submit" value="수정" />
</form>
<a href="/board/detail.do?idx=${article.idx}">취소</a>
<a href="/board/list.do">목록으로</a>