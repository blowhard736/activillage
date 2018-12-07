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
<script type="text/javascript">
	$(function() {
		$("#kyeong").click(function() {
			$("#search_name").val("do_name");
			$("#search_keyword").val("경기도");
			$("#goGoodsList").attr({
				"method" : "get",
				"action" : "/goods/goodsList.do"
			});
			$("#goGoodsList").submit();
		});
		$("#kang").click(function() {
			$("#search_name").val("do_name");
			$("#search_keyword").val("강원도");
			$("#goGoodsList").attr({
				"method" : "get",
				"action" : "/goods/goodsList.do"
			});
			$("#goGoodsList").submit();
		});
		$("#choong").click(function() {
			$("#search_name").val("do_name");
			$("#search_keyword").val("충청도");
			$("#goGoodsList").attr({
				"method" : "get",
				"action" : "/goods/goodsList.do"
			});
			$("#goGoodsList").submit();
		});
		$("#jeon").click(function() {
			$("#search_name").val("do_name");
			$("#search_keyword").val("전라도");
			$("#goGoodsList").attr({
				"method" : "get",
				"action" : "/goods/goodsList.do"
			});
			$("#goGoodsList").submit();
		});
		$("#kyeongsang").click(function() {
			$("#search_name").val("do_name");
			$("#search_keyword").val("경상도");
			$("#goGoodsList").attr({
				"method" : "get",
				"action" : "/goods/goodsList.do"
			});
			$("#goGoodsList").submit();
		});
		$("#jeju").click(function() {
			$("#search_name").val("do_name");
			$("#search_keyword").val("제주도");
			$("#goGoodsList").attr({
				"method" : "get",
				"action" : "/goods/goodsList.do"
			});
			$("#goGoodsList").submit();
		});
	});
</script>
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
				<div class="kyeong" id="kyeong">
					<a>경기도</a>
				</div>
				<div class="kang" id="kang">
					<a>강원도</a>
				</div>
				<div class="choong" id="choong">
					<a>충청도</a>
				</div>
				<div class="jeon" id="jeon">
					<a>전라도</a>
				</div>
				<div class="kyeongsang" id="kyeongsang">
					<a>경상도</a>
				</div>
				<div class="jeju" id="jeju">
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