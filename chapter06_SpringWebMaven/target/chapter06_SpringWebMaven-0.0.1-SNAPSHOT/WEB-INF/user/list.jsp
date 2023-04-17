<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#currentPaging {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
#paging { 
	color: black;
	text-decoration: none;
	cursor: pointer;
}
#userPagingDiv {
	/* border: 1px solid red; */
	text-align: center;
	margin-top: 5px;
	width:456px;
}
#userPagingDiv span#paging, span#currentPaging {
	display: inline-block;
	width: 20px;
	height: 20px;
}
</style>
</head>
<body>
<h3>
	<a href="/chapter06_SpringWebMaven/">
		<img src="../image/apeach.gif" alt="apeach" width="50" height="50">
	</a>목록</h3>
<input type="text" id="pg" value="${pg }">	

<table id="userListTable" border="1" frame="hsides" rules="rows">
	<tr>
		<th width="150">이름</th>
		<th width="150">아이디</th>
		<th width="150">비밀번호</th>
	</tr>
	
	<!-- 동적처리 -->
</table>

<div id="userPagingDiv"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
<script type="text/javascript">
function userPaging(pg) { //onclick='userPaging("+(startPage-1)+") 이에서 startPage-1 이 pg 값으로 들어온다. 
	location.href = "/chapter06_SpringWebMaven/user/list?pg="+pg;
}
</script>
</body>
</html>