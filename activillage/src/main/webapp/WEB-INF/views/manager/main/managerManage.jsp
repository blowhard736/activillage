<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tld/custom_tag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.managerContainer {
	width: 1184px;
	height: auto;
}
.order{
	cursor: pointer;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("[id='manager_retire_btn']").click(function() {
			if (confirm("정말 탈퇴 시키겠습니까?")) {
				$("[id='m_data']").attr({
					"method" : "post",
					"action" : "/manager/retire"
				});
				alert("해당 관리자가 탈퇴되었습니다.");
				$("[id='m_data']").submit();
			}
		});

		/* 검색 후 검색 대상과 검색 단어 출력 */
		var word = "<c:out value='${m_data.keyword}' />";

		if (word != "") {
			$("#keyword").val("<c:out value='${m_data.keyword}' />");
		}

		/* 한페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로 유지하기 위한 설정*/
		if ("<c:out value='${m_data.pageSize}' />" != "") {
			$("#pageSize").val("<c:out value='${m_data.pageSize}' />");
		}

		/* 검색 버튼 클릭 시 처리 이벤트 */
		$("#searchManagerData").click(function() {
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
		
		$("#totalManager").click(function(){
			$("#keyword").val("");
			$("#m_search").attr({
				"method" : "get",
				"action" : "/manager/manage.do"
			});
			$("#m_search").submit();
		});
	});

	/* 검색과 한 페이지에 보여줄 레코드 수 처리 및 페이징을 위한 실질적인 처리 함수 */
	function goPage(page) {

		$("#page").val(page);
		$("#m_search").attr({
			"method" : "get",
			"action" : "/manager/manage.do"
		});
		$("#m_search").submit();
	}
</script>
</head>
<body>
	<div class="managerContainer">
		<h2>관리자 관리</h2>
		<hr>
		<%-- ================== 검색기능 시작 ================= --%>
		<div class="searchManager">
			<form id="m_search" name="m_search">
			<input type="hidden" id="page" name="page" value="${m_data.page}"/>
				<input type="hidden" id="order_by" name="order_by"
					value="${m_data.order_by}" /> <input type="hidden" id="order_sc"
					name="order_sc" value="${m_data.order_sc}" />
				<table summary="검색">

					<tr>
						<td id="btd1">
						<button id="totalManager">전체 관리자</button>
						<input type="text" name="keyword" id="keyword"
							placeholder="이름을 입력하세요" /> <input type="button" value="검색"
							id="searchManagerData" /></td>

					</tr>
				</table>
			</form>
		</div>
		<%-- ================== 리스트 시작 ================= --%>
		<div class="managerList">
			<table class="table table-bordered">
				<%-- table-striped --%>
				<thead>
					<tr>
						<th class="tac">아이디</th>
						<th data-value="m_name" class="order">이름 <c:choose>
								<c:when
									test="${m_data.order_by=='m_name' and  m_data.order_sc=='ASC'}">▲</c:when>
								<c:when
									test="${m_data.order_by=='m_name' and  m_data.order_sc=='DESC'}">▼</c:when>
								<c:otherwise>▲</c:otherwise>
							</c:choose>
						</th>
						<th data-value="m_joinday" class="order">등록일 <c:choose>
								<c:when
									test="${m_data.order_by=='m_joinday' and  m_data.order_sc=='ASC'}">▲</c:when>
								<c:when
									test="${m_data.order_by=='m_joinday' and  m_data.order_sc=='DESC'}">▼</c:when>
								<c:otherwise>▲</c:otherwise>
							</c:choose>
						</th>
						<th class="tac">강제탈퇴</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty managerList}">
							<c:forEach var="manager" items="${managerList}"
								varStatus="status">
								<tr class="tac">
									<td>${manager.m_id}</td>
									<td>${manager.m_name}</td>
									<td>${manager.m_joinday}</td>
									<td><form name="m_data" id="m_data">
											<button id="manager_retire_btn" value="${manager.m_no}">강제탈퇴</button>
											<input type="hidden" id="m_no" name="m_no"
												value="${manager.m_no}">
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
		<%-- =============== 페이지 네비게이션 시작 =============== --%>
		<div id="boardPage">
			<tag:paging page="${param.page}" total="${total}"
				list_size="${m_data.pageSize}" />
		</div>
	</div>
</body>
</html>