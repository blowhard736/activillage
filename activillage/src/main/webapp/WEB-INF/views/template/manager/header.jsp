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
.logo{
	width: 141px;
	height: 33px;
	float: left;
}
.category{
	float: right;
}
</style>
<script type="text/javascript">
	$(function() {
	});
</script>
<title>헤더</title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="/"><img alt="로고 이미지" src="/resources/images/logo/logo.png"></a>
		</div>
		<div class="category">
			<p>회원정보관리/예약정보/고객센터/통계정보<a href="/manager/logout.do">/로그아웃</a>
		</div>
	</div>
</body>
</html>