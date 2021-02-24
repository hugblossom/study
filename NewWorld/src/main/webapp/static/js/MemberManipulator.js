const MemberManipulator = {
	init: function() {
		var _this = this;
		
		var getMemberBtn = document.querySelector("#getMemberBtn");
		
		if ( getMemberBtn ) {
			getMemberBtn.addEventListener("click", function(){
				event.preventDefault();
				_this.select();
			});
		}
		
		var getMemberListBtn = document.querySelector("#getMemberListBtn");
	
		if ( getMemberListBtn ) {
			getMemberListBtn.addEventListener("click", function() {
				event.preventDefault();
				_this.selectList();
			});
		} 
		
		var memberModifyBtn = document.querySelector("#memberModifyBtn");
		
		if ( memberModifyBtn ) {
			memberModifyBtn.addEventListener("click", function() {
				event.preventDefault();
				_this.update();
			});
		} 
	},
	select: function() {
		var target = document.querySelector("input[name=mem_idx]");
		var mem_idx = target.value;
		var xhr = new XMLHttpRequest();
		
		if ( !xhr ) {
			alert("XMLHttpRequest instantiation exception");
			return false;
		}
		
		if ( !mem_idx ) {
			alert("조회할 멤버 번호를 입력하세요");
			target.focus();
			return false;
		}
		
		xhr.open("GET", "/api/v1/members/" + mem_idx);
		xhr.setRequestHeader("Content-Type","application/json");
		xhr.send();
		
		xhr.onreadystatechange = function() {
			
			if( xhr.readyState === XMLHttpRequest.DONE ) {
				if ( xhr.status === 200  || xhr.status === 201 ) {
					alert(xhr.responseText);
				} else {
					alert("회원정보 조회 실패 + 번호:" + mem_idx);
				}
				
			}
		}
	},
	selectList: function() {
		var xhr = new XMLHttpRequest();
		
		if ( !xhr ) {
			alert("XMLHttpRequest instantiation exception");
			return false;
		}
				
		xhr.open("GET", "/api/v1/members/");
		xhr.setRequestHeader("Content-Type","application/json");
		xhr.send();
		
		xhr.onreadystatechange = function() {
			if( xhr.readyState === XMLHttpRequest.DONE ) {
				if ( xhr.status === 200  || xhr.status === 201 ) {
					alert(xhr.responseText);
				} else {
					alert("회원정보 조회 실패 + 번호:" + mem_idx);
				}
			}
		}
		
	},
	update: function() {
		var xhr = new XMLHttpRequest();
		var mem_idx = document.querySelector("input[name=mem_idx]").value;
		var mem_id = document.querySelector("input[name=mem_id]").value;
		var mem_nick = document.querySelector("input[name=mem_nick]").value;
		var mem_passwd = document.querySelector("input[name=mem_passwd]").value;
		var mem_email = document.querySelector("input[name=mem_email]").value;
		var data = {
			"mem_idx" : mem_idx,
			"mem_id" : mem_id,
			"mem_nick" : mem_nick,
			"mem_passwd" : mem_passwd,
			"mem_email" : mem_email
		}
		
		if ( !xhr ) {
			alert("XMLHttpRequest instantiation exception");
			return false;
		}
				
		xhr.open("PUT", "/api/v1/members/" + mem_idx);
		xhr.setRequestHeader("Content-Type","application/json");
		xhr.send(JSON.stringify(data));
		
		xhr.onreadystatechange = function() {
			if( xhr.readyState === XMLHttpRequest.DONE ) {
				if ( xhr.status === 200  || xhr.status === 201 ) {
					alert(xhr.responseText);
				} else {
					alert("회원정보 조회 실패 + 번호:" + mem_idx);
				}
			}
		}
	}
}

MemberManipulator.init();