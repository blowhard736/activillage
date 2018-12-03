<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 등록 페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/join/seller/sellerjoin.js" ></script>
<script type="text/javascript" src="/resources/include/js/join/seller/sellercommon.js"></script>
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
	width: 547px;
	height: 678px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="from">
			<form class="mainForm">
				<div class="form-group">
					<input type="email" id="s_email" name="s_email" placeholder="아이디(이메일)" maxlength="50" />
					<input type="button" id="idConfirmBtn" value="아이디 중복체크" />
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="password" id="s_pw" name="s_pw" placeholder="비밀번호(숫자포함 영문8자 이상 20자 이하)" min="8" maxlength="20" />
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="password" id="pwCheck" name="pwCheck" placeholder="비밀번호 확인" min="8" maxlength="20" />
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="text" id="s_bnum" name="s_bnum" placeholder="사업자등록번호(-포함12자리)" maxlength="12"/>
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="text" id="s_bname" name="s_bname" placeholder="대표자명(한글 10자제한,영문 20자제한)" min="3" maxlength="20" />
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="text" id="s_cname" name="s_cname" placeholder="회사명(한글 25자제한,영문 50자제한)" min="25" maxlength="50"/>
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="text" id="s_phone" name="s_phone" placeholder="연락처(-없이 11자리)" maxlength="11" />
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="checkbox" id="agree" name="agree" />약관동의
				</div>
				<div class="col-sm-5">
					<p class="error"></p>
				</div>
				<div>
					<input type="button" value="사업자 등록" id="sellerjoinInsert" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>