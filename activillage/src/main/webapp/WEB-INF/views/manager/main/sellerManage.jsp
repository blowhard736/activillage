<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 관리</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
#container {
	width: 1184px;
}

#side {
	width: 250px;
	float: left;
}

#main {
	width: 924px;
	float: right;
}
</style>
<script type="text/javascript">
$(function(){
	$("#salesManageBtn").click(function(){
		location.href="/manager/main/salesManage.do";
	});
});
</script>
</head>
<body>
	<div id="container">
		<h2>사업자 관리</h2>
		<p>
		<hr>
		<div id="side">
			<%@ include file="../include/memberType.jsp"%>
		</div>
		<div id="main">
			<div>
				<select>
					<option>회사명</option>
					<option>대표자명</option>
				</select> <input id="u_name" name="u_name" type="text">
				<button id="search_u_name" name="search_u_name">검색</button>
			</div>
			<div>사업자정보</div>
			<div>
				<label>사업자 수 : </label> <input type="text" id="user_count"
					name="user_count">
				<button id="salesManageBtn">매출현황</button>
			</div>
			<div>페이징</div>
		</div>
	</div>
</body>
</html>