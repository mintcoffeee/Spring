$(function(){
	$('#updateForm').hide();	
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
				
				//dataType: 'json',
				/*
				아이디가 없으면 UserDTO가 JSON으로 오지만
				아이디가 없으면 JSON 으로 오지를 못
				이럴경우 dataType을 생략한다.(dataType을 생략하면 자료에 맞게 자동으로 형식이 지정된다.)
				*/
				
				success: function(data) {
					console.log(JSON.stringify(data));
					
					if(data == '') {
						$('#resultDiv').text('찾고자 하는 아이디가 없습니다.');
						
					} else {
						$('#updateForm').show();
						$('#name').val(data.name);
						$('#id').val(data.id);
						$('#pwd').val(data.pwd);
						
						$(document).on('click', '#updateBtn', function(){
							if(confirm('정말 수정하시겠습니까?')){
								$.ajax({
									type: 'post',
									url: '/chapter06_SpringWebMaven/user/update',
									data: $('#updateForm').serialize(),
									success: function(data) {
										alert('수정되었습니다');
										location.href='/chapter06_SpringWebMaven/';
									},
									error: function(err){ console.log() }
								});
							} else { alert('취소되었습니다.'); }
						});
						$(document).on('click', '#resetBtn', function(){
							$('#name').val(data.name);
							$('#pwd').val(data.pwd);
						});
						
					}
				},
				error: function(err) {
					console.log(err);
				}
			});
		
		}
		
	});
});