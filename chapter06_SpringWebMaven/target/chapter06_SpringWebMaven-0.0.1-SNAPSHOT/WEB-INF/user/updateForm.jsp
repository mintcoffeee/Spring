<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a { text-decoration: none; color:black;}
#resultDiv, #updateForm div {
color: red;
font-size: 9px;
font-weight: bold;
}
</style>
</head>
<body>
<h3>
	<a href="/chapter06_SpringWebMaven/">
		<img src="../image/apeach.gif" alt="apeach" width="50" height="50">
	</a>회원 정보 수정</h3>
	<br>
	
<p>
 수정할 아이디 입력 : <input type="text" id="searchId" placeholder="아이디를 입력하세요">
 <input type="button" id="searchIdBtn" value="검색">
</p>
<div id="resultDiv"></div>


<!-- 아이디가 db에 있으면 빨강박스가 보이면서 데이터 채워져 있어야 한다. -->
<div id="updateDiv">
<form id="updateForm">
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
				<input type="text" name="id" id="id" readonly="readonly">
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
				<input type="button" id="updateBtn" value="수정" >
				<input type="button" id="resetBtn" value="취소">
			</td>
		</tr>
	</table>
</form>

</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/update.js"></script>
</body>
</html>




