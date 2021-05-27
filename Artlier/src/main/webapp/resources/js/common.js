$(document).ready(function() {

	$('.btn_like.locked').click(function(e) {
	
		e.preventDefault();
	
		alert("내 글에 좋아요 할 수 없습니다");
		
	});
	
	$('.reply_view .btn_toggle').click(function() {
		var $this = $(this);
		var thisAction = $this.data("action");
		
		if ( thisAction == "modify" ) {
			if ( $this.hasClass("on") ) {
				$this.removeClass("on").text("수정").parents('.reply_view').removeClass("on");
			} else {
				$this.addClass("on").text("취소").parents('.reply_view').addClass("on");
			}	
		}
		if ( thisAction == "reply" ) {
			if ( $this.hasClass("on") ) {
				$this.removeClass("on").text("댓글").parents('.reply_view').removeClass("reply");
			} else {
				$this.addClass("on").text("취소").parents('.reply_view').addClass("reply");
			}	
		}		
		

	});
	
	
	
});