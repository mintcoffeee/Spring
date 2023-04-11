<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<form action="result.do" method="post">
	<label for="name">이름 : </label>
	<input type="text" name="name"  id="name"/><br><br>
	
	<label for="kor">국어 : </label>
	<input type="text" name="kor" id="kor"/><br><br>
	
	<label for="eng">영어 : </label>
	<input type="text" name="eng" id="eng"/><br><br>
	
	<label for="math">수학 : </label>
	<input type="text" name="math" id="math"/><br><br>
	
	<input type="submit" value="계산"> 
	<input type="reset" value="취소"> 
</form>
</body>
</html>