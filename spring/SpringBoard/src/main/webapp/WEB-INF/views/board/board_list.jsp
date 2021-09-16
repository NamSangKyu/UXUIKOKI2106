<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
</head>
<body>
	${sessionScope.client.id }님이 로그인하셨습니다.<br>
	<a href="logout.do">로그아웃</a>
</body>
</html>