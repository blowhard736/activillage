<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 통계</title>
<style type="text/css">
.container {
	width: 1184px;
}

.side {
	width: 250px;
	float: left;
}

.sellerContainer {
	width: 924px;
	float: right;
}
</style>
</head>
<body>
	<div class="container">
		<h2>사업자 지역별 등록 수</h2>
		<hr>
		<div class="side">
			<%@ include file="../include/chartType.jsp"%>
		</div>
		<div class="sellerContainer">
			<img src="/graph/sellerPieChart.jpg" class="img-thumbnail" />
		</div>
	</div>
</body>
</html>