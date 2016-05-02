/* ID CHECK */
$(document).ready(function() {
	$('#email').keyup(function idC() {
		if ($('#email').val().length > 9) {
			var email = $(this).val();
			// ajax start
			$.ajax({
				type : 'POST',
				url : '/InterlineLoginMail3/idcheck.action?',
				dataType : 'json',
				data : {
					email : email
				},
				success : function(result) {
					console.log(result);
					if (result.idCheck == true) {
						$("#IdCheckSection").html("<font color=bule>使用不可</font>メールです。");
						return false;
					} else {
						$("#IdCheckSection").html("使用可能メールです。");
					}
				}
			}); // end ajax
		}
	}); // end keyup
});
	$(function() {
		$('#passwordCheck').click(
				function() {
					var password = $('#password').val();
					var password2 = $('#password2').val();
					if (password == null || password == "" && password2 == null
							|| password2 == "") {
						alert("パスワードを入力してください。");
						return false;
					} else if (password != password2) {
						alert("入力した、パスワードが一致していません。");
						return false;
					}
					console.log(email);
			});
		});

