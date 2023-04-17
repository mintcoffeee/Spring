$(function(){
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		if(!$('#searchId').val()) {
			$('#resultDiv').text('아이디를 입력해주세요');
			$('#searchId').focus();
		} else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/getUser',
				data: 'id='+$('#searchId').val(),
				success: function(data) {
					console.log(JSON.stringify(data));
					
					if(data == '') {
						$('#resultDiv').text('찾고자 하는 아이디가 없습니다.')
							.css('color','red').css('font-size','9px').css('font-wight','600');
						
					} else {
						//삭제
						if(confirm('삭제하시겠습니까?')) {
							$.ajax({
								type: 'post',
								url: '/chapter06_SpringWebMaven/user/delete',
								data: 'id='+$('#searchId').val(),
								success: function(){
									alert('회원 정보를 삭제하였습니다');
									location.href='/chapter06_SpringWebMaven/user/list';
								},
								error: function(err) {
									console.log(err);
								}
							});
						}//if
					}
				},
				error: function(err) {
					console.log(err);
				}
			});//ajax
		
		}
		
	});
});