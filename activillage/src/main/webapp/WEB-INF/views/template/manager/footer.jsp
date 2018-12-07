<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<style type="text/css">
.container {
	width: 1184px;
	height: 200px;
	clear: both;
}

.category {
	float: right;
}

.text {
	width: 1184px;
	clear: both;
}
</style>
<div class="container">
	<div class="category">
		<%
			if (session.getAttribute("m_id") != null) {
				if (session.getAttribute("m_id").equals("admin")) {
		%>
		<a href="/mainjoin/managerJoin.do">관리자 등록</a> <a
			href="/manager/manage.do">/관리자 관리</a>
		<%
			}
			}
		%>
	</div>
	<div class="text">
		<p>04704 서울시 성동구 무학로2길 54 / 대표자명 정현준 한만제 고종륜 박우람 조성환 김정휘/ Tel :
			02) 441-6006 / Fax : 02) 428-9694 / zldehowlfj@naver.com /
			Copyright(c) 2018 All Rights Reserved</p>
	</div>
</div>
