<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Artlier</title>
<link rel="stylesheet" href="/resources/css/common.css" />
<script src="/resources/js/jquery-3.1.1.min.js"></script>
<script src="/resources/js/common.js"></script>
</head>
<body>
	<header id="hd">
		<div class="member_box">
			<div class="tool_box">
			<c:if test="${sessionScope.member_id eq null}">
				로그인해주세요 <a href="/member/login">로그인</a> <a href="/member/join">회원가입</a>
			</c:if>
			<c:if test="${sessionScope.member_id ne null}">
				${sessionScope.member_nick} 님 반갑습니다 <a href="/member/list">회원리스트</a> <a href="/member/logout">로그아웃</a>
			</c:if>
			</div>
			<c:if test="${sessionScope.member_id ne null}">
			<div class="notification_box">
				<c:if test="${fn:length(notificationList) == 0}">
					<p>알림이 없습니다.</p>
				</c:if>
				<c:if test="${fn:length(notificationList) != 0}">
				<p class="notification_count">새 알림 <span>${notificationNewCount}</span></p>
				<div class="notification_list_box">
					<ol class="notification_list">
						<c:forEach items="${notificationList}" var="row">
							<li class="${row.checked eq 0 ? '' : 'checked'}">
								<a href="/board/common/detail?code=${row.target_code}&uid=${row.target_uid}&page=${row.target_page}" class="btn_notification" data-action="move">
									<p class="notification_info">내 ${row.target_name}에 대해 ${row.mem_nick}님의 ${row.notify_action_name}</p>
									<p class="notification_contents">${row.contents}</p>
								</a>
								<button type="button" class="btn btn_notification" data-action="delete">삭제</button>
								<form id="notificationForm">
									<input type="hidden" name="target" value="${row.target}">
									<input type="hidden" name="target_code" value="${row.target_code}">
									<input type="hidden" name="target_uid" value="${row.target_uid}">
									<input type="hidden" name="target_mem_id" value="${row.target_mem_id}">
									<input type="hidden" name="uid" value="${row.uid}">
									<input type="hidden" name="mem_id" value="${row.mem_id}">
									<input type="hidden" name="mem_nick" value="${row.mem_nick}">
									<input type="hidden" name="notify_action" value="${row.notify_action}">
									<input type="hidden" name="json_action" value="">
								</form>
							</li>
						</c:forEach>
					</ol>
					<button type="button" class="btn btn_notification" data-action="delete_all">전체삭제</button>
				</div>
				</c:if>
			</div>
			<script src="/resources/js/jQuery.serializeObject.js"></script>
			<script>
				$(document).on("click", ".btn_notification", function(event) {
					var $this = $(this);
					var $thisList = $(this).parents('li');
					var thisAction = $(this).data("action");
					
					if ( thisAction == "move" ) {	
						var uri = $this.attr("href");
						var isChecked = $this.parents('li').hasClass("checked");

						if ( isChecked ) {
							location.href=uri;
						} else {
							ajaxMove(uri);
						}
					}
					
					if ( thisAction == "delete" ) {
						
						if (confirm("알림을 삭제하시겠습니까?")) {
							$('input[name=json_action]').val("delete");
							
							ajaxDelete($thisList, thisAction);	
						}
						
					}
					
					if ( thisAction == "delete_all" ) {
						
						if (confirm("알림을 모두 삭제하시겠습니까?")) {
							$('input[name=json_action]').val("delete_all");
							
							ajaxDelete($thisList, thisAction);
						}
						
					}
	
					event.preventDefault();
					
				});
				
				function ajaxMove(uri) {
					var formData = $("#notificationForm").serializeObject();
					$.ajax({
						url:'/member/notification',
						type:'POST',
						contentType:'application/json',
						data:JSON.stringify(formData),
						success: function(data) {
							if ( data > 0 ) location.href=uri;
						},error:function(xhs, status, error) {
							alert("error");
						}
					});
					return false;
				}
				
				function ajaxDelete(obj, act) {
					var formData = $("#notificationForm").serializeObject();
					$.ajax({
						url:'/member/notification/delete',
						type:'POST',
						contentType:'application/json',
						data:JSON.stringify(formData),
						success: function(data) {
							if ( act == "delete" ) {
								if ( data > 0 ) {
									if ( obj.index() == 0 ) {
										$('.notification_box').empty();
										$('.notification_box').append("<p>알림이 없습니다</p>");					
									} else {
										obj.remove();
										$('.notification_count > span').text($('.notification_list').children('li:not(.checked)').length);
									}
								}
							}
							if ( act == "delete_all") {
								if ( data > 0 ) {
									$('.notification_box').empty();
									$('.notification_box').append("<p>알림이 없습니다</p>")	
								}
							}
							
						},error:function(xhs, status, error) {
							alert("error");
						}
					});
					return false;
				}
				
			</script>
			</c:if>
		</div>
		<div class="gnb_box">
			<a href="/board/common/list?code=NM&page=1">자유게시판</a>
			/ <a href="/board/gallery/list">이미지게시판</a>
		</div>
		
	</header>