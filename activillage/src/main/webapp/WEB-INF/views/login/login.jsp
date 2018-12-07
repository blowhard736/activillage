<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="/resources/include/js/login/login.js"></script>
<script type="text/javascript"
	src="/resources/include/js/login/logincommon.js"></script>
<script>
	$(document).ready(function() {
		var code = $("#err_code").val();
		if (code == 2) {
			alert("가입승인대기상태입니다. 관리자에게 문의하세요.");
			location.href = "/login/login";
		} else if (code == 3) {
			alert("로그인 실패!");
			code=0;
			location.href = "/login/login";
		}
		
		$("#u_email").hide();
		$("#u_pw").hide();
		$("input[type=radio][value=seller]").attr({
			"checked" : "checked"
		});

		$("input[type=radio][value=seller]").click(function() {
			$("#s_email").show();
			$("#s_pw").show();
			$("#u_email").hide();
			$("#u_pw").hide();
			$(".error1").show();
			$(".error2").show();
			$(".error3").hide();
			$(".error4").hide();
		});

		$("input[type=radio][value=user]").click(function() {
			$("#u_email").show();
			$("#u_pw").show();
			$("#s_email").hide();
			$("#s_pw").hide();
			$(".error3").show();
			$(".error4").show();
			$(".error1").hide();
			$(".error2").hide();
		});

	});
</script>
<style type="text/css">
#wrapper {
	margin: auto;
	border: 1px solid silver;
	overflow: hidden;
	width: 100%;
	height: 714px;
}

#from {
	margin: auto;
	margin-top: 60px;
	border: 1px solid silver;
	text-align: center;
	overflow: hidden;
	width: 447px;
	height: 578px;
}

#content {
	margin: auto;
	margin-top: 275px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="from">
			<form id="loginForm" name="loginForm">
				<input type="hidden" id="err_code" value="${code}">
				<div id="content">
					<input type="hidden" id="division" name="division" /> <input
						type="radio" name="login" value="seller">사업자 <input
						type="radio" name="login" value="user">사용자
				</div>
				<div>
					<input type="text" id="s_email" name="s_email"
						placeholder="사업자아이디(이메일)" maxlength="50" />
					<div class="col-sm-5">
						<p class="error1"></p>
					</div>
					<input type="password" id="s_pw" name="s_pw" placeholder="사업자비밀번호"
						min="8" maxlength="20" />
					<div class="col-sm-5">
						<p class="error2"></p>
					</div>
					<input type="text" id="u_email" name="u_email"
						placeholder="사용자아이디(이메일)" maxlength="50" />
					<div class="col-sm-5">
						<p class="error3"></p>
					</div>
					<input type="password" id="u_pw" name="u_pw" placeholder="사용자비밀번호"
						min="8" maxlength="20" />
					<div class="col-sm-5">
						<p class="error4"></p>
					</div>
				</div>
				<div>
					<a href="/login/idfind">아이디 찾기</a> <a href="/login/pwfind">비밀번호
						찾기</a>
				</div>
				<div>
					<input type="button" id="login" value="로그인">
				</div>
				<div>
					<input type="button" id="join" value="회원가입">
				</div>
			</form>
		</div>
	</div>
</body>
</html>