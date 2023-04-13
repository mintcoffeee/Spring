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
						
						/*숙제 혼자 한 것 
						//수정
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
						//취소
						$(document).on('click', '#resetBtn', function(){
							$('#name').val(data.name);
							$('#pwd').val(data.pwd);
						});
						*/
					}
				},
				error: function(err) {
					console.log(err);
				}
			});//ajax
		
		}
		
	});
});

//취소 버튼
$('#resetBtn').click(function(){
	//강제 이벤트 발생 
	//취소 버튼을 누르면 수정아이디 검색 버튼(#searchIdBtn)을 누른 것과 같은 이벤트가 일어나야 한다. 
	$('#searchIdBtn').trigger('click');
	
});


//수정 버튼
$('#updateBtn').click(function(){
	if(!$('#name').val()){
		$('#nameDiv').text('이름을 입력하세요')
		$('#name').focus();
	} else if(!$('#pwd').val()){
		$('#pwdDiv').text('비밀번호를 입력하세요')
		$('#id').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/update',
			data: $('#updateForm').serialize(),
			success: function(data) {
				alert('회원님의 정보를 수정하였습니다');
				location.href='/chapter06_SpringWebMaven/user/list';
			},
			error: function(err){ console.log() }
		});
	}
});







