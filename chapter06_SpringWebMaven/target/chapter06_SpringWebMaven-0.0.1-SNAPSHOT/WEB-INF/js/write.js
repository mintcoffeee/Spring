$(function(){
	
	$('#writeBtn').bind('click', function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if(!$('#name').val()){
			$('#nameDiv').text('이름을 입력하세요')
			$('#name').focus();
		} else if(!$('#id').val()){
			$('#idDiv').text('아이디를 입력하세요')
			$('#id').focus();
		} else if(!$('#pwd').val()){
			$('#pwdDiv').text('비밀번호를 입력하세요')
			$('#id').focus();
		} else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/write',
				data: $('#writeForm').serialize(),
				success: function(){
					alert('회원가입을 축하합니다.');
					location.href='/chapter06_SpringWebMaven/user/list';
				},
				error: function(err){ console.log(err) }
			});
		}
		
	});
});


//아이디 중복체크
//이벤트  발생 - 먼저 아이디 입력
$('#id').focusout(function(){
	$('#idDiv').empty();
	if(!$('#id').val()){
		$('#idDiv').text('아이디를 입력하세요')
		$('#id').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/isExistId',
			data: 'id='+ $('#id').val(),
			dataType: 'text', //서버로부터 받는 데이터형 text, json, xml
							 //아이디가 있으면 "exist", 아이디가 없으면 "non-exist"
			success: function(data){
				if(data == "exist"){
					$('#idDiv').text('사용 불가능');
				} else if(data == "non_exist"){
					$('#idDiv').text('사용 가능');
					$('#idDiv').css('color','blue');
				}
			},
			error: function(err){ console.log(err) }
		});
	}
});


