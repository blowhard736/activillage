<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 타입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/join/main/join.js"></script>
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

#content {
	margin: auto;
	margin-top: 275px;
}

/* #btn1 {
	width: 150px;
	height: 150px;
}

#btn2 {
	width: 150px;
	height: 150px;
} */

</style>
</head>
<body>
	<div id="wrapper">
		<div id="from">
			<div id="content">
				<!-- <input type="button" id="btn" value="관리자" id="managerJoinBtn" /> -->
				<input type="button" value="사업자" id="sellerJoinBtn" />
				<input type="button" value="사용자" id="userJoinBtn" />
			</div>
		</div>
	</div>
</body>
</html>