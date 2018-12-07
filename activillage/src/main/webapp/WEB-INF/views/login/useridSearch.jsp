<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 아이디 찾기 페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/resources/include/js/login/login.js"></script>
<script type="text/javascript">
/* 아이디 찾기 이벤트 */
$(document).on('click','#idsearchBtn',function(){
	
	var u_phone = $('#u_phone').val();
	var postData = {'u_phone' : u_phone}
	
	$.ajax({
		url:'/login/useridsearch',
		type:'POST',
		data:postData,
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        dataType :"json",
        
        success:function(data) {
        	$("#useridList").append("<h4>"+"회원님의 정보로 등록된 아이디는 : "+data.u_email+" 입니다.</h4>");
        	$("#idsearchBtn").attr('disabled', true);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert('정보를 다시 입력해주시길 바랍니다.' );
        }
	});
});
</script>
<style type="text/css">
#wrapper {
	margin: auto;
	border: 1px solid silver;
	overflow:hidden;
	width: 100%;
	height: 714px;
}

#from {
	margin: auto;
	margin-top: 60px;
	border: 1px solid silver;
	text-align: center;
	overflow:hidden;
	width: 547px;
	height: 678px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="from">
			<table border="1">
				<tr height="40">
					<td align="center" width="200">전화번호</td>
					<td width="300"><input type="text" id="u_phone" name="u_phone" size="30" placeholder="연락처(-없이 11자리)" maxlength="11"></td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2">
						<input type="button" value="아이디찾기" id="idsearchBtn" />
						<input type="button" value="로그인 페이지" id="userBackBtn" />
					</td>
				</tr>
			</table>
			<span id="useridList" ></span>
		</div>
	</div>	
</body>
</html>