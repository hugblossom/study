<%@ include file="../layout/header.jsp" %>

<h1>member - list</h1>

<c:forEach items="${memberList}" var="row" varStatus="status">
	<p>${row.uid} / ${row.id} / ${row.email}</p>
</c:forEach>

<%@ include file="../layout/footer.jsp" %>