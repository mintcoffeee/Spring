<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a { text-decoration: none; color:black;}
#writeForm td div {
color: red;
font-size: 9px;
font-weight: bold;
}
</style>
</head>
<body>
<form id="writeForm">
<h3>
	<a href="/chapter06_SpringWebMaven/">
		<img src="../image/apeach.gif" alt="apeach" width="50" height="50">
	</a>회원가입</h3>
	<table>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" id="name">
				<div id="nameDiv"></div>
			</td>
			
		</tr>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" id="id">
				<div id="idDiv"></div>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pwd" id="pwd">
				<div id="pwdDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="button" value="등록" id="writeBtn">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/write.js"></script>
</body>
</html>