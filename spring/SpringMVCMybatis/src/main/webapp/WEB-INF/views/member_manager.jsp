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
	<hr>
	<div class="result">
	<!-- 전체 회원 목록을 출력 -->
	<c:forEach var="obj" items="${requestScope.list }">
		<form>
		<input type="text" name="id" value="${obj.id }">
		<input type="text" name="passwd" value="${obj.pass }">
		<input type="text" name="name" value="${obj.name }">
		<input type="text" name="age" value="${obj.age }">
		<input type="text" name="grade" value="${obj.grade }">
		<button type="button" class="btnUpdate">수정</button>
		<button type="button" class="btnDelete">삭제</button><!-- 삭제 처리 Ajax로 삭제 처리 -->
		</form>
		
	</c:forEach>
	</div>
</body>
</html>