<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${param.x } + ${param.y } = ${param.x +param.y  } --%>

<h3>${x } + ${y } = ${x + y }</h3>
<%-- x+y 는 자료형을 따지지 않기 때문에 string 도 연산 가능  --%>
</body>
</html>