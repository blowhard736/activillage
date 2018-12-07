<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>헤더</title>
<script type="text/javascript">
   $(function() {

      var word = "<c:out value='${data.search_keyword}' />";
      var value = "";
      if (word != "") {
         $("#search_name").val("<c:out value='${data.search_name}' />");
         $("#search_keyword")
               .val("<c:out value='${data.search_keyword}' />");
      }

      $("#search_button").click(function() {
         $("#goGoodsList").attr({
            "method" : "get",
            "action" : "/goods/goodsList.do"
         });
         $("#goGoodsList").submit();
      });

      $("#logout").click(function() {
         alert("로그아웃하시겠습니까?");
      });
   });
</script>
</head>
<body>
   <div class="header">
      <div class="logo">
         <a href="/"><img alt="로고 이미지"
            src="/resources/images/logo/logo.png"></a>
      </div>
      <form id="goGoodsList">
         <div class="search_bar">
            <select name="search_name" id="search_name">
               <option value="goods_name">상품명</option>
               <option value="do_name">지역명</option>
            </select> <input type="text" name="search_keyword" id="search_keyword"
               placeholder="지역 및 상품명을 검색해 보세요"> <input type="button"
               value="검색" id="search_button">
         </div>
      </form>
      <div>
         <c:if test="${sessionScope.loginType !=('user' || 'seller')}">
            <a href="/login/login.do">로그인</a>
            <a href="/join/join.do">회원가입</a>
         </c:if>
         <c:if test="${sessionScope.loginType == ('user' || 'seller')}">
            <a href="/mypage/myPage.do">마이 페이지</a>
            <a href="/login/logout.do" id="logout">로그아웃</a>
         </c:if>
      </div>

   </div>
</body>
</html>