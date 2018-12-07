$(document).ready(function() {
	// 로그인
	$("#login").click(function() {
		
		$("#division").val($("input[name=login]:checked").val());
		
		if ($("#division").val() == "seller") {
			
			if (!formCheck($('#s_email'), $('.error1'), "사업자 아이디를"))	return;
			else if (!inputVerify(0,'#s_email','.error1'))	return;
			else if (!formCheck($('#s_pw'),$('.error2'), "사업자 비밀번호를"))	return;
			else if (!inputVerify(2,'#s_pw', '.error2'))	return;
				else {
					$("#loginForm").attr({
						"method" : "post",
						"action" : "/login/sellerLogin"
					});
					$("#loginForm").submit();
				}
			}
			
		
		if ($("#division").val() == "user") {
			if (!formCheck($('#u_email'), $('.error3'), "사용자 아이디를"))	return;
			else if (!inputVerify(0,'#u_email','.error3'))	return;
			else if (!formCheck($('#u_pw'),$('.error4'), "사용자 비밀번호를"))	return;
			else if (!inputVerify(2,'#u_pw', '.error4'))	return;
				else {
					$("#loginForm").attr({
						"method" : "post",
						"action" : "/login/userLogin"
					});
					$("#loginForm").submit();
				}
			}
		
	});
	
	// 회원가입
	$("#join").click(function() {
		location.href="/login/join";
	});
	
	// 사업자 닫기 버튼
	$("#sellerBackBtn").click(function() {
		location.href="/login/sellerBack";
	});
	
	// 사용자 닫기 버튼
	$("#userBackBtn").click(function() {
		location.href="/login/userBack";
	});
	
	// 사업자 아이디 찾기
	$("#selleridfindBtn").click(function() {
		location.href="/login/selleridfind";
	});
	
	// 사용자 아이디 찾기
	$("#useridfindBtn").click(function() {
		location.href="/login/useridfind";
	});
	
	// 사업자 비밀번호 찾기
	$("#sellerpwfindBtn").click(function() {
		location.href="/login/sellerpwfind";
	});
	
	// 사용자 비밀번호 찾기
	$("#userpwfindBtn").click(function() {
		location.href="/login/userpwfind";
	});
	
	/* 사업자 비밀번호 찾기 버튼 클릭 시 처리 이벤트 */
	$("#sellermove").click(function(){
		//입력값 체크
		if (!formCheck($('#s_email'), $('.error1'), "아이디(이메일)를")) return;
		else if (!inputVerify(0,'#s_email', '.error1')) return;
		
		else if (!formCheck($('#s_phone'), $('.error2'), "연락처를")) return;
		else if (!inputVerify(1,'#s_phone', '.error2'))	return;
		
		else {
			$(".sellerMoveForm").attr({
				"method":"post",
				"action":"/login/sellermove"
			});
			$(".sellerMoveForm").submit();
		}
	});
	
	/* 사용자 비밀번호 찾기 버튼 클릭 시 처리 이벤트 */
	$("#usermove").click(function(){
		//입력값 체크
		if (!formCheck($('#u_email'), $('.error1'), "아이디(이메일)를")) return;
		else if (!inputVerify(0,'#u_email', '.error1')) return;
		
		else if (!formCheck($('#u_phone'), $('.error2'), "연락처를")) return;
		else if (!inputVerify(1,'#u_phone', '.error2'))	return;
		
		else {
			$(".userMoveForm").attr({
				"method":"post",
				"action":"/login/usermove"
			});
			$(".userMoveForm").submit();
		}
	});
	
	/* 사업자 비밀번호 찾기 버튼 클릭 시 처리 이벤트 */
	$("#sellerfindBtn").click(function(){
		//입력값 체크
		if (!formCheck($('#s_pw'), $('.error1'), "비밀번호를")) return;
		else if (!inputVerify(2,'#s_pw', '.error1')) return;
		
		else if (!formCheck($('#pwCheck'), $('.error2'), "비밀번호 확인을"))	 return;
		else if (!inputVerify(2,'#pwCheck', '.error2'))	return;
		else if (!sellerPasswordCheck()) return;
		
		else {
			$(".sellerPwForm").attr({
				"method":"post",
				"action":"/login/sellerchange"
			});
			$(".sellerPwForm").submit();
		}
	});
	
	/* 사용자 비밀번호 찾기 버튼 클릭 시 처리 이벤트 */
	$("#userfindBtn").click(function(){
		//입력값 체크
		if (!formCheck($('#u_pw'), $('.error1'), "비밀번호를")) return;
		else if (!inputVerify(2,'#u_pw', '.error1')) return;
		
		else if (!formCheck($('#pwCheck'), $('.error2'), "비밀번호 확인을"))	 return;
		else if (!inputVerify(2,'#pwCheck', '.error2'))	return;
		else if (!userPasswordCheck()) return;
		
		else {
			$(".userPwForm").attr({
				"method":"post",
				"action":"/login/userchange"
			});
			$(".userPwForm").submit();
		}
	});
	
	// 사업자 비밀번호와 비밀번호 확인 일치 여부 확인
	function sellerPasswordCheck(){
		if($("#s_pw").val() != $("#pwCheck").val()){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			$("#pwCheck").focus();
			$("#pwCheck").val("");
			return false;
		}else{		
			return true;
		}
	}
	
	// 사용자 비밀번호와 비밀번호 확인 일치 여부 확인
	function userPasswordCheck(){
		if($("#u_pw").val() != $("#pwCheck").val()){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
			$("#pwCheck").focus();
			$("#pwCheck").val("");
			return false;
		}else{		
			return true;
		}
	}
	
});