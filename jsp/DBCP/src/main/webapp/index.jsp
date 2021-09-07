<%@page import="java.sql.Connection"%>
<%@page import="config.DBManager"%>
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
		Connection conn = DBManager.getInstance().getConnection();
		if(conn != null)
			System.out.println("DB 접속 성공");
%>
</body>
</html>