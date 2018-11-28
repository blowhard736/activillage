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
</style>
<script type="text/javascript">
	$(function() {

	});
</script>
<title><tiles:getAsString name="header" /></title>
</head>
<body>
	<div class="header">
		<div class="logo">
			<img alt="로고 이미지" src="">
		</div>
		<div class="search_bar">
			<select name="search_name" id="search_name">
				<option value="goods_name">상품명</option>
				<option value="do_name">지역명</option>
			</select> <input type="text" name="search_keyword" id="search_keyword"
				placeholder="지역 및 상품명을 검색해 보세요"> <input type="button"
				value="검색" id="search_button">
		</div>
		<div>
			<a href="/WEB-INF/views/mypage/myPage.jsp">마이 페이지</a> <a
				href="/WEB-INF/views/login/login.jsp">로그인</a> <a
				href="/WEB-INF/views/join/userJoin.jsp">회원가입</a>
		</div>
	</div>
</body>
</html>