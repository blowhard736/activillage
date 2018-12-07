<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 관리</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
.container {
	width: 1184px;
}

.side {
	width: 250px;
	float: left;
}

.sellerContainer {
	width: 924px;
	float: right;
}

.order {
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(function() {
		//승인버튼 이벤트
		$("[id='seller_approval_btn']").click(function() {
			if (confirm("정말 승인 하시겠습니까?")) {
				$("[id='approval']").attr({
					"method" : "post",
					"action" : "/manager/approval"
				});
				alert("해당 사업자가 승인되었습니다.");
				$("[id='approval']").submit();
			}
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
		var word = "<c:out value='${s_data.keyword}' />";
		var value = "";
		if (word != "") {
			$("#keyword").val("<c:out value='${s_data.keyword}' />");
			$("#search").val("<c:out value='${s_data.search}' />");
		}

		/* 한페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로 유지하기 위한 설정*/
		if ("<c:out value='${s_data.pageSize}' />" != "") {
			$("#pageSize").val("<c:out value='${s_data.pageSize}' />");
		}

		/* 검색 대상이 변경될 때마다 처리 이벤트 */
		$("#search").change(function() {
			if ($("#search").val() == "all") {
				$("#keyword").val("전체 데이터 조회합니다.");
			} else if ($("#search").val() != "all") {
				$("#keyword").val("");
				$("#keyword").focus();
			}
		});

		/* 검색 버튼 클릭 시 처리 이벤트 */
		$("#searchSellerData").click(function() {
			/* if ($("#search").val() != "all") {
				if (!chkSubmit($('#keyword'), "검색어를"))
					return;
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

		/* 한 페이지에 보여줄 레코드 수 변경될 때마다 처리 이벤트 */
		$("#pageSize").change(function() {
			goPage(1);
		});

		$("#salesManageBtn").click(function() {
			location.href = "/manager/main/salesManage.do";
		});
	});

	/* 검색과 한 페이지에 보여줄 레코드 수 처리 및 페이징을 위한 실질적인 처리 함수 */
	function goPage(page) {
		if ($("#search").val() == "all") {
			$("#keyword").val("");
		}
		$("#page").val(page);
		$("#s_search").attr({
			"method" : "get",
			"action" : "/manager/main/sellerManage.do"
		});
		$("#s_search").submit();
	}
</script>
</head>
<body>
	<div class="container">
		<h2>사업자 관리</h2>
		<p>
		<hr>
		<div class="side">
			<%@ include file="../include/memberType.jsp"%>
		</div>
		<div class="sellerContainer">

			<%-- ================== 검색기능 시작 ================= --%>
			<div id="sellerSearch">
				<form id="s_search" name="s_search">
					<input type="hidden" id="page" name="page" value="${s_data.page}" />
					<input type="hidden" id="order_by" name="order_by"
						value="${s_data.order_by}" /> <input type="hidden" id="order_sc"
						name="order_sc" value="${s_data.order_sc}" />
					<table summary="검색">
						<tr>
							<td id="btd1"><select id="search" name="search">
									<option value="all">전체</option>
									<option value="s_cname">회사명</option>
									<option value="s_bname">대표자명</option>
							</select> <input type="text" name="keyword" id="keyword"
								value="전체 데이터를 조회합니다" /> <input type="button" value="검색"
								id="searchSellerData" /></td>
						</tr>
					</table>
				</form>
			</div>

			<%-- =================== 리스트 시작  ================= --%>
			<div id="sellerList">
				<table summary="사업자 리스트">
					<thead>
						<tr>
							<th>아이디</th>
							<th data-value="s_cname" class="order">회사명 <c:choose>
									<c:when
										test="${s_data.order_by=='s_cname' and  s_data.order_sc=='ASC'}">▲</c:when>
									<c:when
										test="${s_data.order_by=='s_cname' and  s_data.order_sc=='DESC'}">▼</c:when>
									<c:otherwise>▲</c:otherwise>
								</c:choose>
							</th>
							<th>대표자명</th>
							<th>연락처</th>
							<th data-value="s_joinday" class="order">등록일 <c:choose>
									<c:when
										test="${s_data.order_by=='s_joinday' and  s_data.order_sc=='ASC'}">▲</c:when>
									<c:when
										test="${s_data.order_by=='s_joinday' and  s_data.order_sc=='DESC'}">▼</c:when>
									<c:otherwise>▲</c:otherwise>
								</c:choose>
							</th>
							<th>승인여부</th>
							<th>승인버튼</th>
							<th>강제탈퇴</th>
						</tr>
					</thead>
					<tbody id="list">
						<!-- 데이터 출력 -->
						<c:choose>
							<c:when test="${not empty sellerList}">
								<c:forEach var="seller" items="${sellerList}" varStatus="status">
									<tr class="tac">
										<td>${seller.s_email}</td>
										<td>${seller.s_cname}</td>
										<td>${seller.s_bname}</td>
										<td>${seller.s_phone}</td>
										<td>${seller.s_joinday}</td>
										<td>${seller.s_approval }</td>
										<c:choose>
											<c:when test="${seller.s_approval eq 'Y'}">
												<td>승인완료</td>
											</c:when>
											<c:otherwise>
												<td><form name="approval" id="approval">
														<button id="seller_approval_btn" value="${seller.s_no}">승인</button>
														<input type="hidden" id="s_no" name="s_no"
															value="${seller.s_no}">
													</form></td>
											</c:otherwise>
										</c:choose>
										<td><form name="withdrawal" id="withdrawal">
												<button id="seller_withdrawal_btn" value="${seller.s_no}">강제탈퇴</button>
												<input type="hidden" id="s_no" name="s_no"
													value="${seller.s_no}">
											</form></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="4" class="tac">등록된 게시물이 존재하지 않습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>

			<div>
				<label>사업자 수 : </label> <input type="text" value="${total}"
					readonly="readonly">
				<button id="salesManageBtn">매출현황</button>
			</div>

			<%-- =============== 페이지 네비게이션 시작 =============== --%>
			<div id="boardPage">
				<tag:paging page="${param.page}" total="${total}"
					list_size="${s_data.pageSize}" />
			</div>

		</div>
	</div>
</body>
</html>