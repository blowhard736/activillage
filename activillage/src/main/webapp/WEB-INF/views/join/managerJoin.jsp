<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 등록 페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/join.js" ></script>
<script type="text/javascript" src="/resources/include/js/common.js"></script>
<script type="text/javascript">
function errCodeCheck(){
	var errCode = '<c:out value="${errCode}" />';
	if(errCode != ''){
		switch (parseInt(errCode)) {
		case 1:
			alert("이미 가입된 회원입니다!");
			break;
		case 2:
			alert("회원가입 처리가 실패하였습니다. 잠시 후 다시 시도해 주십시오.");
			break;
		}
	}
}
</script>
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
			<form class="mainForm">
				<div class="form-group">
					<input type="text" id="m_id" name="m_id" placeholder="아이디" />
					<input type="button" id="idConfirmBtn" value="아이디 중복체크" />
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="password" id="m_pw" name="m_pw" placeholder="비밀번호" />
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
					<input type="text" id="m_name" name="m_name" placeholder="이름" />
				</div>
				<div class="col-sm-5">
					<p class="error3"></p>
				</div>
				<div>
					<input type="button" value="관리자 등록" id="mainjoinInsert" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>