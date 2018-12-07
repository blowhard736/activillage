$(function(){
	
	/* 관리자 등록 버튼 클릭 시 처리 이벤트 
	$("#managerJoinBtn").click(function(){
		location.href="/mainjoin/managerJoin";
	});*/
	
	/* 사업자 등록 버튼 클릭 시 처리 이벤트 */
	$("#sellerJoinBtn").click(function() {
		location.href="/join/sellerJoin.do";
	});
	
	/* 사용자 회원가입 버튼 클릭 시 처리 이벤트 */
	$("#userJoinBtn").click(function() {
		location.href="/join/userJoin.do";
	});
	
});