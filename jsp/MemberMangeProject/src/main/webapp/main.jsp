<%@page import="dto.MemberDTO"%>
<%@page import="service.MemberService"%>
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
	MemberDTO dto =(MemberDTO)session.getAttribute("obj");
		
	%>
	
	<%=dto.getName() %>님 로그인 하셨습니다.
</body>
</html>