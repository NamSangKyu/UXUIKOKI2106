<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request : <%=request.getAttribute("req") %><br>
	session : <%=session.getAttribute("session") %>
	<!-- session 정보 초기화 -->
	<a href="invalid.jsp">session 초기화</a>
	
</body>
</html>