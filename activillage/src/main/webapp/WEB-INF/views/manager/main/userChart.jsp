<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 통계</title>
<style type="text/css">
.container {
	width: 1184px;
}

.side {
	width: 250px;
	float: left;
}

.userContainer {
	width: 924px;
	float: right;
}
</style>
</head>
<body>
	<div class="container">
		<h2>일반 회원 나이별 가입자 수</h2>
		<hr>
		<div class="side">
			<%@ include file="../include/chartType.jsp"%>
		</div>
		<div class="userContainer">
			<img src="/graph/userPieChart.jpg" class="img-thumbnail" />
		</div>
	</div>
</body>
</html>