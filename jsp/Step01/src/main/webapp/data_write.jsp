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
	String data = request.getParameter("data");
	int end = Integer.parseInt(data);
	
	for(int i=0;i<end;i++){
%>
		<p><%=i + 1%></p>
<%
	}
%>
</body>
</html>