<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#modifyOk").click(function() {
			$("#userModifyForm").attr({
				"method" : "post",
				"action" : "/mypage/user/modifyInfo.do"
			});
			$("userModifyForm").submit();
		});
	});
</script>
<style type="text/css">
#modifyCancle {
	margin-right: 20px;
}
</style>
</head>

<body>
	<h2>modifyInfo.jsp</h2>

	<form id="userModifyForm">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center"><h3>회원정보 변경</h3></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="u_no" id="u_no"
					value="${user.u_no}" /></td>
			</tr>
			<tr>
				<td><label>아이디</label></td>
				<td><input type="text" value="${user.u_email}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td><label>이름</label></td>
				<td><input type="text" value="${user.u_name}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td><label>생년월일</label></td>
				<td><input type="text" value="${user.u_birth}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td><label for="u_phone">휴대폰번호</label></td>
				<td class="td_u_phone"><input type="text" id="u_phone"
					name="u_phone" value="${user.u_phone}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					id="modifyCancle" value="취소"><input type="submit"
					id="modifyOk" value="저장"></td>
		</table>
	</form>
</body>
</html>