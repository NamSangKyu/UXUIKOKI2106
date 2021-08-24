<%@page import="obj.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person Result</title>
</head>
<body>
	<%
		Person p = (Person)request.getAttribute("obj");
	%>
	이름 : <%=p.getName() %>
	나이 : <%=p.getAge() %>
</body>
</html>