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
	//post일 경우 패킷으로 오기떄문에 문자코드 떄문에 깨짐. utf-8로 변환
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String major = request.getParameter("major");
	String hak = request.getParameter("hak");	
%>
	<%=name %><br>
	<%=major%><br>
	<%=hak %><br>
</body>
</html>