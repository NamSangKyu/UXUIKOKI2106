<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("test","쿠기내용");
	cookie.setMaxAge(30);//초단위
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<a href="cookie_result.jsp">쿠기 조회 페이지 이동</a>
</body>
</html>