<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String do_name = request.getParameter("search_keyword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function() {
		
		$(".total").click(function() {
			$("#g_category").val("total");
			$("#category_form").attr({
				"method":"get",
				"action":"/goods/goodsList.do"
			});
			$("#category_form").submit();
		});
		$(".sky").click(function() {
			$("#g_category").val('sky');
			$("#category_form").attr({
				"method":"get",
				"action":"/goods/goodsList.do"
			});
			$("#category_form").submit();
		});
		$(".land").click(function() {
			$("#g_category").val('land');
			$("#category_form").attr({
				"method":"get",
				"action":"/goods/goodsList.do"
			});
			$("#category_form").submit();
		});
		$(".aqua").click(function() {
			$("#g_category").val('aqua');
			$("#category_form").attr({
				"method":"get",
				"action":"/goods/goodsList.do"
			});
			$("#category_form").submit();
		});
	});
</script>
<style>
.aside {
	float: left;
	width: 250px;
	height: 210px;
}

.goods {
	
}

.contents {
	width: 1184px;
	height: auto;
	clear : both;
}

.body {
	width: 924px;
	float: right;
	height: 2065px;
}

.goods {
	width: 866px;
	height: 162px;
}

#g_thumb {
	width: 230px;
	height: 149px;
}

.g_name {
	font-size: 18px;
}

.g_price {
	font-size: 22px;
}

.do_name {
	font-size: 20px;
}

.total, .sky, .land, .auqa {
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="contents">
		<div class="aside">
			<form name="category_form" id="category_form">
			<input type="hidden" id="g_category" name="g_category">
				<ul>
					<li value="total" class="total" id="total"><label>전체</label></li>
					<li value="sky" class="sky" id="sky"><label>하늘</label></li>
					<li value="land" class="land" id="land"><label>땅</label></li>
					<li value="aqua" class="aqua" id="aqua"><label>물</label></li>
				</ul>
			</form>
		</div>
		<div class="body">

			<div class="goods">
				<a href="goods/goodsDetail.do"> <!-- 데이터 출력 --> <c:choose>
						<c:when test="${not empty goodsList }">
							<c:forEach items="${goodsList}" var="goodsList">
								<img src="${goodsList.g_thumb}" id="g_thumb">
								<div class="g_name">${goodsList.g_name}</div>
								<div class="g_price">${goodsList.g_price}</div>
								<div class="g_grade">${goodsList.g_grade}</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="notHaveList">
								<label>등록된 상품이 없습니다.</label>
							</div>
						</c:otherwise>
					</c:choose>
				</a>
			</div>

		</div>
	</div>
</body>
</html>