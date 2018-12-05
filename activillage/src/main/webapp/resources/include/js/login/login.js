
$(document).ready(function() {
	$("#login").click(function() {
		$("#division").val($("input[name=login]:checked").val());

		if ($("#division").val() == "seller") {
			$("#loginForm").attr({
				"method" : "post",
				"action" : "/login/sellerLogin"
			});
			$("#loginForm").submit();
		}

		if ($("#division").val() == "user") {
			$("#loginForm").attr({
				"method" : "post",
				"action" : "/login/userLogin"
			});
			$("#loginForm").submit();
		}

	});
});
