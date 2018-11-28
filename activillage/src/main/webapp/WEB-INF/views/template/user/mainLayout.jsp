<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header" />
	</nav>

	<!-- Begin page content -->
	<div class="container">
		<p>사진
		<p>상품리스트
		<p>인기상품
	</div>
	<!--/.container-->

	<footer class="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>