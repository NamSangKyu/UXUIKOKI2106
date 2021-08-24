<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 초기화</title>
</head>
<body>
	<%
		session.invalidate();//세션 초기화
	%>
	<a href="session_result.jsp">session result 페이지 이동</a>
</body>
</html>