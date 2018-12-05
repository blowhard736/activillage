$(document).ready(function() {
	$("#login").click(function() {
		$("#division").val($("input[name=login]:checked").val());

		if ($("#division").val() == "seller") {
			$("#loginForm").attr({
				"method" : "post",
				"action" : "/login/sellerLogin"
			});
			$("#loginForm").submit();
		}

		if ($("#division").val() == "user") {
			$("#loginForm").attr({
				"method" : "post",
				"action" : "/login/userLogin"
			});
			$("#loginForm").submit();
		}

	});

	var code = "<c:out value='${code}' />";
	var approval = "<c:out value='${approval}' />";
	if (code == 1 && approval == 'Y') {
		alert("로그인 성공!");
		$("#id").show();
	} else if (code == 1 && approval == 'N') {
		alert("가입승인대기상태입니다. 관리자에게 문의하세요.");
		location.href = "/login/login";
	} else if (code == 0) {
		alert("로그인 실패!");
		$("#fail").show();
	}
});
