<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<style type="text/css">
.mainImage {
	width: 100%;
	height: 300px;
}

.container {
	width: 1184px;
	margin: auto;
}

.text {
	width: 1184px;
	clear: both;
}

.text span {
	font-size: 24px;
	font-weight: normal;
}

.total {
	float: right;
}

.goodsList {
	width: 1184px;
	margin: auto;
	clear: both;
}

.goodsList div {
	width: 394.63px;
	height: 252px;
	float: left;
	text-align: center;
	padding-top: 10px;
	cursor: pointer;
}

.goodsList div a {
	position: relative;
	top: 100px;
	font-size: 24px;
	font-weight: bold;
	color: #fff;
}

.kyeong {
	background-image: url('/resources/images/mainpage/kyeongki.jpg');
	background-repeat: no-repeat;
}

.kang {
	background-image: url('/resources/images/mainpage/kangwon.jpg');
	background-repeat: no-repeat;
}

.choong {
	background-image: url('/resources/images/mainpage/choongchung.jpg');
	background-repeat: no-repeat;
}

.jeon {
	background-image: url('/resources/images/mainpage/jeonla.png');
	background-repeat: no-repeat;
}

.kyeongsang {
	background-image: url('/resources/images/mainpage/kyeongsang.jpg');
	background-repeat: no-repeat;
}

.jeju {
	background-image: url('/resources/images/mainpage/jeju.jpg');
	background-repeat: no-repeat;
}

.popular {
	clear: both;
}

.footer {
	clear: both;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>

	<!-- Begin page content -->
	<div class="mainImage">
		<img alt="메인페이지 사진" src="/resources/images/mainpage/mainimage1.jpg">
	</div>
	<div class="container">
		<div class="text">
			<span>지역별</span><a class="total">전체보기&gt;</a>
		</div>
		<div class="goodsList">
			<div class="kyeong"
				onclick="location.href='/manager/main/userManage.do'">
				<a>경기도</a>
			</div>
			<div class="kang">
				<a>강원도</a>
			</div>
			<div class="choong">
				<a>충청도</a>
			</div>
			<div class="jeon">
				<a>전라도</a>
			</div>
			<div class="kyeongsang">
				<a>경상도</a>
			</div>
			<div class="jeju">
				<a>제주도</a>
			</div>
		</div>
		<div class="popular">인기상품</div>
	</div>
	<!--/.container-->

	<footer class="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>