<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 영역 - 1</title>
</head>
<body>
<%
	application.setAttribute("app_num", 777);
%>
	<%=application.getServerInfo() %><br>
	<%=application.getRealPath("applcation_1.jsp") %><br>
	<a href="application_2.jsp">다음페이지</a>
</body>
</html>