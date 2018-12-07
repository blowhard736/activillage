<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지메인</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".li_userModifyInfo").click(function() {
			$(".content").load("/mypage/user/modifyInfo.do");
		});

		$(".li_userReservation").click(function() {
			$(".content").load("/mypage/user/reservation.do");
		});

		$(".li_sellerModifyInfo").click(function() {
			$(".content").load("/mypage/seller/modifyInfo.do");
		});

		$(".li_sellerModifyPw").click(function() {
			$(".content").load("/mypage/seller/modifyPw.do");
		});

		$(".li_sellerRegisterGoods").click(function() {
			$(".content").load("/mypage/seller/goodsRegister.do");
		});

		$(".li_goodsManage").click(function() {
			$(".content").load("/mypage/seller/manageGoods.do");
		});

		$(".li_reservationManage").click(function() {
			$(".content").load("/mypage/seller/reservationManage.do");
		});

		$(".li_salesPresent").click(function() {
			$(".content").load("/mypage/seller/salesPresent.do");
		});

	});
</script>
</head>
<style type="text/css">
.wrapper {
	width: 1184px;
	height: 1000px;
}

.aside {
	width: 250px;
	height: auto;
	float: left;
}

.content {
	width: 924px;
	height: auto;
	float: left;
	border: 1px 1px solid;
}

.aside_ul {
	list-style: none;
}

.aside_ul {
	line-height: 50px;
}
</style>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>

	<div class="wrapper">
		<div class="aside">
			<c:if test="${sessionScope.loginType == 'user'}">
				<ul class="aside_ul">
					<li class="li_userModifyInfo">정보변경</li>
					<li class="li_userModifyPw">비밀번호 변경</li>
					<li class="li_userReservation">예약확인</li>
					<li class="li_userRetire">회원탈퇴</li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.loginType == 'seller'}">
				<ul class="aside_ul">
					<li class="li_sellerModifyInfo">정보변경</li>
					<li class="li_sellerModifyPw">비밀번호 변경</li>
					<li class="li_sellerRegisterGoods">상품등록</li>
					<li class="li_goodsManage">상품관리/패키지등록</li>
					<li class="li_reservationManage">예약관리</li>
					<li class="li_salesPresent">매출현황</li>
					<li class="li_sellerRetire">회원탈퇴</li>
				</ul>
			</c:if>
		</div>
		<div class="content">
			<center>
				<fieldset id="loginInfo">
					<legend>
						<img alt="로고사진" src="/resources/images/logo/logoimage.jpg"><br>
						<strong> <c:out value="${loginSession.u_email}"></c:out>님 환영합니다.
						</strong>
					</legend>
				</fieldset>
			</center>
		</div>
	</div>
</body>
</html>