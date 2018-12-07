<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 비밀번호 찾기 페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/login/login.js"></script>
<script type="text/javascript" src="/resources/include/js/login/logincommon.js"></script>
<style type="text/css">
#wrapper {
	margin: auto;
	border: 1px solid silver;
	overflow:hidden;
	width: 100%;
	height: 714px;
}

#from {
	margin: auto;
	margin-top: 60px;
	border: 1px solid silver;
	text-align: center;
	overflow:hidden;
	width: 447px;
	height: 578px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="from">
			<form class="sellerMoveForm">
				<div>
					<input type="text" id="s_email" name="s_email" placeholder="아이디(이메일)" maxlength="50" />
				</div>
				<div class="col-sm-5">
					<p class="error1"></p>
				</div>
				<div>
					<input type="text" id="s_phone" name="s_phone" placeholder="전화번호(-없이 11자리)" maxlength="11" />
				</div>
				<div class="col-sm-5">
					<p class="error2"></p>
				</div>
				<div>
					<input type="button" id="sellermove" value="비밀번호 찾기">
				</div>
			</form>
		</div>
	</div>
</body>
</html>