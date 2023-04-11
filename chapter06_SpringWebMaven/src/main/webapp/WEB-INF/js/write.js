$(function(){
	
	$('#writeBtn').bind('click', function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if(!$('#name').val()){
			$('#nameDiv').text('이름을 입력하세요')
					.css({'color':'red','font-size':'10px'});
			$('#name').focus();
			return false;
		}
		
		if(!$('#id').val()){
			$('#idDiv').text('아이디를 입력하세요')
					.css({'color':'red','font-size':'10px'});
			$('#id').focus();
			return false;
		}
		if(!$('#pwd').val()){
			$('#pwdDiv').text('비밀번호를 입력하세요')
					.css({'color':'red','font-size':'10px'});
			$('#id').focus();
			return false;
		}
	});
});