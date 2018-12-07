<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
.header {
	width: 1184px;
	height: 75px;
}

.logo {
	width: 141px;
	height: 33px;
	float: left;
}

.category {
	float: right;
}
</style>

<title>헤더</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="/"><img alt="로고 이미지"
				src="/resources/images/logo/logo.png"></a>
		</div>
		<div class="category">
			<%
				if (session.getAttribute("m_id") != null) {
			%>
			<a href="/manager/main/userManage">회원정보관리</a>
			<a>/예약정보</a>
			<a>/고객센터</a>
			<a href="/manager/userChart">/통계정보</a>
			<a href="/manager/logout.do">/로그아웃</a>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>