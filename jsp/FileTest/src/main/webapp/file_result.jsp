<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${requestScope.user }가 보낸 파일 목록</h2>
	<c:forEach var="list" items="${requestScope.file }">
		<p><a href="fileDown.do?file=${ list.fileName}&writer=${requestScope.user }">${ list.fileName}</a>,${ list.path},${list.type}</p>
	</c:forEach>
</body>
</html>