// 비밀번호와 비밀번호 확인 일치 여부 확인
function passwordCheck() {
	if ($("#m_pw").val() != $("#pwCheck").val()) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		$("#pwCheck").focus();
		$("#pwCheck").val("");
		return false;
	} else {
		return true;
	}
}
// 아이디에 비밀번호 포함 여부 확인
function idPwdCheck() {
	var userId = $("#m_id").val();
	var userPw = $("#m_pw").val();
	if (userPw.indexOf(m_id) > -1) {
		alert("비밀번호에 아이디를 포함할 수 없습니다.");
		$("#m_pw").val("");
		$("#m_pw").focus();
		return false;
	} else {
		return true;
	}
}

var idConfirm = 1;
$(function() {

	/* 관리자 등록 버튼 클릭 시 처리 이벤트 */
	$("#managerJoinBtn").click(function() {
		location.href = "/mainjoin/managerJoin";
	});

	/* 사업자 등록 버튼 클릭 시 처리 이벤트 */
	$("#sellerJoinBtn").click(function() {
		location.href = "/join/sellerJoin";
	});

	/* 사용자 회원가입 버튼 클릭 시 처리 이벤트 */
	$("#userJoinBtn").click(function() {
		location.href = "/join/userJoin";
	});

	errCodeCheck();
	// 사용자에게 요구사항에 대한 문자열로 배열 초기화.
	var message = [ "영문,숫자만 가능. 6 ~ 12자로 입력해 주세요",
			"영문,숫자,특수문자만 가능. 8 ~ 15자 입력해 주세요.", "비밀번호와 비밀번호 확인란은 값이 일치해야 합니다.",
			"- 포함 입력해 주세요. 예시) 010-0000-0000" ];

	$('#m_id, #m_pw, #pwCheck, #m_name').bind("focus", function() {
		var idx = $("#m_id, #m_pw, #pwCheck, #m_name").index(this);
		$(this).parents(".error").html(message[idx]);
	});

	/* 아이디 중복체크 */
	$("#idConfirmBtn").click(function() {
		if (!formCheck($('#m_id'), $('.error:eq(0)'), "아이디를"))
			return;
		else {
			$.ajax({
				url : "/mainjoin/idConfirm",
				type : "post",
				data : "m_id=" + $("#m_id").val(),
				error : function() {
					alert('사이트 접속에 문제로 정상 작동하지 못하였습니다. 잠시 후 다시 시도해 주세요.');
				},
				success : function(resultData) {
					console.log("resultData : " + resultData);
					if (resultData == "1") {
						$(".error").html("현재 사용 중인 아이디입니다.");
						idConfirm = 1;
					} else if (resultData == "2") {
						$(".error").html("사용 가능한 아이디입니다.");
						idConfirm = 2;
						$("#m_id").attr('readonly', true);
						$("#idConfirmBtn").attr('disabled', true);

					}
				}
			});
		}
	});

	/* 확인 버튼 클릭 시 처리 이벤트 */
	$("#mainjoinInsert").click(function() {
		// 입력값 체크
		if (!formCheck($('#m_id'), $('.error'), "아이디를"))
			return;
		else if (idConfirm != 2) {
			alert("아이디 중복 체크 진행해 주세요.");
			return;
		} else if (!inputVerify(0, '#m_id', '.error'))
			return;
		else if (!formCheck($('#m_pw'), $('.error1'), "비밀번호를"))
			return;
		else if (!inputVerify(1, '#m_pw', '.error1'))
			return;
		else if (!idPwdCheck())
			return;
		else if (!formCheck($('#pwCheck'), $('.error2'), "비밀번호 확인을"))
			return;
		else if (!inputVerify(1, '#pwCheck', '.error2'))
			return;
		else if (!passwordCheck())
			return;
		else if (!formCheck($('#m_name'), $('.error3'), "이름을"))
			return;
		else {
			if (confirm("등록하시겠습니까?")) {
				$(".mainForm").attr({
					"method" : "post",
					"action" : "/mainjoin/mainjoin"
				});
				alert("관리자 등록이 완료되었습니다.");
				$(".mainForm").submit();
			} else {
				location.href = "/mainjoin/managerJoin.do"
			}
		}
	});

});