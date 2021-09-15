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
	${sessionScope.dto.id }님 로그인<br>
	<!-- 로그아웃 처리 -->
	<a href="logout.do">로그아웃</a>	
	<hr>
	<!-- 전체 회원 목록을 출력 -->
	<c:forEach var="obj" items="${requestScope.list }">
		<form>
		<input type="text" name="id" value="${obj.id }">
		<input type="text" name="passwd" value="${obj.pass }">
		<input type="text" name="name" value="${obj.name }">
		<input type="text" name="age" value="${obj.age }">
		<input type="text" name="grade" value="${obj.grade }">
		<a href="#">수정</a>
		<a href="#">삭제</a>
		</form>
		
	</c:forEach>
</body>
</html>