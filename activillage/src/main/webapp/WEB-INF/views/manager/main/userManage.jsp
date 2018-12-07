<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 회원 관리</title>
<style type="text/css">
.container {
	width: 1184px;
}

.side {
	width: 250px;
	float: left;
}

.userContainer {
	width: 924px;
	float: right;
}

.order {
	cursor: pointer;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//로그인
		var m_code = $("#m_code").val();
		if (m_code == 2) {
			alert("아이디나 비밀번호가 틀립니다.");
			m_code = 0;
		}

		$("#managerLoginBtn").click(function() {
			$("#managerLoinForm").attr({
				"method" : "post",
				"action" : "/manager/login.do"
			});
			$("#managerLoinForm").submit();
		});

		/* $("[id='manager_retire_btn']").click(function() {
			if (confirm("정말 탈퇴 시키겠습니까?")) {
				$("[id='u_data']").attr({
					"method" : "post",
					"action" : "/manager/retire"
				});
				alert("해당 관리자가 탈퇴되었습니다.");
				$("[id='u_data']").submit();
			}
		}); */

		/* 검색 후 검색 대상과 검색 단어 출력 */
		var word = "<c:out value='${u_data.keyword}' />";

		if (word != "") {
			$("#keyword").val("<c:out value='${u_data.keyword}' />");
		}

		/* 한페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로 유지하기 위한 설정*/
		if ("<c:out value='${u_data.pageSize}' />" != "") {
			$("#pageSize").val("<c:out value='${u_data.pageSize}' />");
		}

		/* 검색 버튼 클릭 시 처리 이벤트 */
		$("#searchUserData").click(function() {
			/* 			if($("#search").val()!="all"){
			 if(!chkSubmit($('#keyword'),"검색어를")) return;
			 } */
			goPage(1);
		});

		$(".order").click(function() {
			var order_by = $(this).attr("data-value");
			console.log("선택값 : " + order_by);

			$("#order_by").val(order_by);
			if ($("#order_sc").val() == 'DESC') {
				$("#order_sc").val('ASC');
			} else {
				$("#order_sc").val('DESC');
			}
			goPage(1);
		});

		$("#totalUser").click(function() {
			$("#keyword").val("");
			$("#u_search").attr({
				"method" : "get",
				"action" : "/manager/main/userManage.do"
			});
			$("#u_search").submit();
		});
	});

	/* 검색과 한 페이지에 보여줄 레코드 수 처리 및 페이징을 위한 실질적인 처리 함수 */
	function goPage(page) {

		$("#page").val(page);
		$("#u_search").attr({
			"method" : "get",
			"action" : "/manager/main/userManage.do"
		});
		$("#u_search").submit();
	}
</script>
</head>
<body>
	<input type="hidden" id="m_code" name="m_code" value="${m_code}" />

	<%
		if (session.getAttribute("m_id") == null) {
	%>
	<form id="managerLoinForm">
		<table width="250" border="1">
			<tr>
				<td><input type="text" id="m_id" name="m_id" placeholder="아이디" /></td>
			</tr>
			<tr>
				<td><input type="password" id="m_pw" name="m_pw"
					placeholder="비밀번호" /></td>
			</tr>
			<tr>
				<td><input type="button" id="managerLoginBtn" value="로그인" /></td>
			</tr>
		</table>
	</form>

	<%
		} else {
	%>
	<div class="container">
		<h2>일반 회원 관리</h2>
		<p>
		<hr>
		<div class="side">
			<%@ include file="../include/memberType.jsp"%>
		</div>
		<div class="userContainer">
			<%-- ================== 검색기능 시작 ================= --%>
			<div class="searchUser">
				<form id="u_search" name="u_search">
					<input type="hidden" id="page" name="page" value="${u_data.page}" />
					<input type="hidden" id="order_by" name="order_by"
						value="${u_data.order_by}" /> <input type="hidden" id="order_sc"
						name="order_sc" value="${u_data.order_sc}" />
					<table summary="검색">

						<tr>
							<td id="btd1">
								<button id="totalUser">전체 관리자</button> <input type="text"
								name="keyword" id="keyword" placeholder="이름을 입력하세요" /> <input
								type="button" value="검색" id="searchUserData" />
							</td>

						</tr>
					</table>
				</form>
			</div>

			<%-- ================== 리스트 시작 ================= --%>
			<div class="userList">
				<table class="table table-bordered">
					<%-- table-striped --%>
					<thead>
						<tr>
							<th class="tac">아이디</th>
							<th data-value="u_name" class="order">이름 <c:choose>
									<c:when
										test="${u_data.order_by=='u_name' and  u_data.order_sc=='ASC'}">▲</c:when>
									<c:when
										test="${u_data.order_by=='u_name' and  u_data.order_sc=='DESC'}">▼</c:when>
									<c:otherwise>▲</c:otherwise>
								</c:choose>
							</th>
							<th class="tac">생년월일</th>
							<th class="tac">연락처</th>
							<th data-value="u_joinday" class="order">등록일 <c:choose>
									<c:when
										test="${u_data.order_by=='u_joinday' and  u_data.order_sc=='ASC'}">▲</c:when>
									<c:when
										test="${u_data.order_by=='u_joinday' and  u_data.order_sc=='DESC'}">▼</c:when>
									<c:otherwise>▲</c:otherwise>
								</c:choose>
							</th>
							<th class="tac">강제탈퇴</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty userList}">
								<c:forEach var="user" items="${userList}" varStatus="status">
									<tr class="tac">
										<td>${user.u_email}</td>
										<td>${user.u_name}</td>
										<td>${user.u_birth}</td>
										<td>${user.u_phone}</td>
										<td>${user.u_joinday}</td>
										<td><form name="u_data" id="u_data">
												<button id="user_withdrawal_btn" value="${user.u_no}">강제탈퇴</button>
												<input type="hidden" id="u_no" name="u_no"
													value="${user.u_no}">
											</form></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6" align="center">현재 회원이 존재하지 않습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>

			<div>
				<label>회원수 : </label><input type="text" value="${total}"
					readonly="readonly">명
			</div>

			<%-- =============== 페이지 네비게이션 시작 =============== --%>
			<div id="boardPage">
				<tag:paging page="${param.page}" total="${total}"
					list_size="${u_data.pageSize}" />
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>