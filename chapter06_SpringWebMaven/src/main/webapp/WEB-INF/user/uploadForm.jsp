<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1. 단순 submit	 -->
<!-- method 는 반드시 post 방식 이어야만 업로드가 가능하다  -->
<form method="post" enctype="multipart/form-data" action="/chapter06_SpringWebMaven/user/upload">
	<input type="file" name="img"><br><br>
	<input type="submit" id="uploadBtn" value="이미지 등록">
</form>





<!-- 2. AJax 통신 -->
</body>
</html>