<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/join.js"></script>
</head>
<body>
	<div>
		<input type="button" value="관리자" id="managerJoinBtn" />
		<input type="button" value="사업자" id="sellerJoinBtn" />
		<input type="button" value="사용자" id="userJoinBtn" />
	</div>
</body>
</html>