<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 비밀번호 찾기 페이지</title>
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
			<form class="userPwForm">
				<input type="hidden" id="u_email" name="u_email" value="${ email }" />
				<div>
					<input type="password" id="u_pw" name="u_pw" placeholder="비밀번호" />
				</div>
				<div class="col-sm-5">
					<p class="error1"></p>
				</div>
				<div>
					<input type="password" id="pwCheck" name="pwCheck" placeholder="비밀번호 확인" />
				</div>
				<div class="col-sm-5">
					<p class="error2"></p>
				</div>
				<div>
					<input type="button" id="userfindBtn" value="비밀번호 찾기">
				</div>
			</form>
		</div>
	</div>
</body>
</html>