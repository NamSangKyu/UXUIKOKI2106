<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parameter 받음</title>
</head>
<body>
	<%
		String data = request.getParameter("data");
	%>
받은 데이터 출력
<div>
	<%=data %>	
</div>
</body>
</html>