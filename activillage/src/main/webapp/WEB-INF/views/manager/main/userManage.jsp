<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#container{
	width: 1184px;
}
#side{
	width: 250px;
	float: left;
}
#main{
	width: 924px;
	float: right;
}
</style>
</head>
<body>
	<%
		if (session.getAttribute("m_id") == null) {
	%>
	<form method="post" action="/manager/login.do">
		<table width="250" border="1">
			<tr>
				<td><input type="text" id="m_id" name="m_id" placeholder="아이디" /></td>
			</tr>
			<tr>
				<td><input type="password" id="m_pw" name="m_pw"
					placeholder="비밀번호" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>

	<%
		} else {
	%>
		<div id="container">
			<h2>일반 회원 관리</h2>
			<p><hr></p>
			<div id="side">
				<%@ include file="../include/memberType.jsp" %>
			</div>
			<div id="main">
				<div>
					<input id="u_name" name="u_name" type="text" placeholder="회원명">
					<button id="search_u_name" name="search_u_name">검색</button>
				</div>
				<div>
					회원정보
				</div>
				<div>
					<label>회원수 : </label>
					<input type="text" id="user_count" name="user_count">
					명
				</div>
				<div>
					페이징
				</div>
			</div>
		</div>
	<%
		}
	%>
</body>
</html>