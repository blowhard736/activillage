<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<div class="container">
	<p>
		1:1문의/공지
		<%
		if (session.getAttribute("loginType") == null || session.getAttribute("loginType").equals("manager")) {
	%>
		<a href="/manager/main/userManage.do">/관리자 페이지</a>
		<%
			}
		%>
	</p>
	<p class="text">04704 서울시 성동구 무학로2길 54 / 대표자명 정현준 한만제 고종륜 박우람 조성환
		김정휘/ Tel : 02) 441-6006 / Fax : 02) 428-9694 / zldehowlfj@naver.com /
		Copyright(c) 2018 All Rights Reserved</p>
</div>
