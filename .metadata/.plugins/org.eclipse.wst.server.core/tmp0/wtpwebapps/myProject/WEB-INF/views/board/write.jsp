<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>article write</div>

<form action="/board/write.do" method="post">
	<p>글제목</p><input type="text" name="title" />
	<p>내용</p><textarea name="contents"></textarea>
	<input type="submit" value="저장" />
</form>
<a href="/board/list.do">목록으로</a>