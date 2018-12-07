// 비밀번호와 비밀번호 확인 일치 여부 확인
function passwordCheck(){
	if($("#u_pw").val() != $("#pwCheck").val()){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		$("#pwCheck").focus();
		$("#pwCheck").val("");
		return false;
	}else{		
		return true;
	}
}
// 아이디에 비밀번호 포함 여부 확인
function idPwdCheck(){
	var userId = $("#u_email").val();
	var userPw = $("#u_pw").val();
	if( userPw.indexOf(u_email) > -1 ){
		alert("비밀번호에 아이디를 포함할 수 없습니다.");
		$("#u_pw").val("");
		$("#u_pw").focus();
		return false;
	}else{		
		return true;
	}
}

var idConfirm = 1;
$(function(){
		
	errCodeCheck();
	// 사용자에게 요구사항에 대한 문자열로 배열 초기화. 
	var message = ["영문,숫자만 가능. 50자 까지 입력해 주세요.",
	               "영문,숫자만 가능. 8 ~ 20자 입력해 주세요.",
	               "비밀번호와 비밀번호 확인란은 값이 일치해야 합니다.",
	               "한글 10자, 영문 20자 까지 입력해 주세요.",
	               "숫자만 가능. 6자 까지 입력해 주세요.",
	               "숫자만 가능. 1자 까지 입력해 주세요.",
	               "–없이,숫자만 가능. 11자 까지 입력해 주세요.",
	               "약관동의를 선택하셔야 등록이 가능합니다."];
	
	$('.error').each(function(index){
		$('.error').eq(index).html(message[index]);
	});
	
	$('#u_email, #u_pw, #pwCheck, #u_name, #u_birth, #u_phone').bind("focus",function() {
		var idx = $("#u_email, #u_pw, #pwCheck, #u_name, #u_birth, #u_phone").index(this);
		$(this).parents(".error").html(message[idx]);
	});
	
	/* 아이디 중복체크 */
	$("#idConfirmBtn").click(function(){
		if (!formCheck($('#u_email'), $('.error:eq(0)'), "아이디를"))	return;
		else if (!inputVerify(0,'#u_email', '.error:eq(0)'))	return;
		else{
			$.ajax({
				url : "/join/useridConfirm",
				type : "post",
				data : "u_email="+$("#u_email").val(),
				error : function(){  
					alert('사이트 접속에 문제로 정상 작동하지 못하였습니다. 잠시 후 다시 시도해 주세요.');
				},
				success : function(resultData){ 
					console.log("resultData : "+resultData);
					if(resultData=="1"){
						$(".error:eq(0)").html("현재 사용 중인 아이디입니다.");
						idConfirm = 1;
					}else if(resultData=="2"){
						$(".error:eq(0)").html("사용 가능한 아이디입니다.");
						idConfirm = 2;
						$("#u_email").attr('readonly', true);
						$("#idConfirmBtn").attr('disabled', true);
					} 
				}
			});
		}
	});
	
	/* 확인 버튼 클릭 시 처리 이벤트 */
	$("#userjoinInsert").click(function(){
		
		var result='';
		$('input[name=u_birth]').map(function(){
			result +=$(this).val();
		});
		alert(result);
		
		//입력값 체크
		if (!formCheck($('#u_email'), $('.error:eq(0)'), "아이디(이메일)를")) return;
		else if (idConfirm!=2){ alert("아이디 중복 체크 진행해 주세요."); return;}
		else if (!inputVerify(0,'#u_email', '.error')) return;
		
		else if (!formCheck($('#u_pw'), $('.error:eq(1)'), "비밀번호를")) return;
		else if (!inputVerify(1,'#u_pw', '.error1')) return;
		else if (!idPwdCheck()) return;
		
		else if (!formCheck($('#pwCheck'), $('.error:eq(2)'), "비밀번호 확인을"))	 return;
		else if (!inputVerify(1,'#pwCheck', '.error2'))	return;
		else if (!passwordCheck()) return;
		
		else if (!formCheck($('#u_name'), $('.error:eq(3)'), "사용자 이름을")) return;
		else if (!inputVerify(2,'#u_name', '.error3'))	return;
		
		else if (!formCheck($('#birth1'), $('.error:eq(4)'), "생년월일을")) return;
		else if (!inputVerify(3,'#birth1', '.error4'))	return;
		else if (!formCheck($('#birth2'), $('.error:eq(5)'), "생년월일을")) return;
		else if (!inputVerify(4,'#birth2', '.error5'))	return;
		
		else if (!formCheck($('#u_phone'), $('.error:eq(6)'), "연락처를")) return;
		else if (!inputVerify(5,'#u_phone', '.error6'))	return;
		
		else if($("#agree").is(":checked") == false){
             alert("약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
             return;
		}
		
		else {
			$(".mainForm").attr({
				"method":"post",
				"action":"/join/userjoin"
			});
			$(".mainForm").submit();
		}
	});
});