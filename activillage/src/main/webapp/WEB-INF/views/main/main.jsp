<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공페이지</title>
</head>
<body>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
		// 로그인
		$("#fail").hide();
		$("#id").hide();
		var code = "<c:out value='${code}' />";
		var approval = "<c:out value='${approval}' />";
		if (code == 1 && approval == 'Y') {
			alert("로그인 성공!");
			$("#id").show();
		} else if (code == 1 && approval == 'N') {
			alert("가입승인대기상태입니다. 관리자에게 문의하세요.");
			location.href="/login/login";
		} else {
			alert("로그인 실패!");
			$("#fail").show();
		}
	});
</script>
	<%	
		if(session.getAttribute("loginType") == "seller") {
	%>
		<h1>사업자</h1>
	<%
		} else {
	%>
		<h1>사용자</h1>
	<%
		}
	%>
	<% String loginId = (String) session.getAttribute("loginId"); %>
	<input type="text" id="id" name="id" value="<% out.print(loginId); %>" />
<div id="fail">로그인 실패</div>
</body>
</html>