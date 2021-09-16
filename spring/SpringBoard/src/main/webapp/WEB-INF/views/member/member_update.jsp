
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>

</head>
<body>
	<c:if test="${sessionScope.client == null }">
		<c:redirect url="/"/>
	</c:if>
	<h2>회원정보 수정 페이지</h2>
	<form action="memberUpdate.do">
		<input type="text" name="id" value="${sessionScope.client.id }" readonly>
		<input type="text" name="pass" placeholder="암호를 입력하세요"><br> 
		<input type="text" name="name" placeholder="이름을 입력하세요" value="${sessionScope.client.name }"><br> 
		<input type="text" name="age" placeholder="나이를 입력하세요" value="${sessionScope.client.age }"><br> 
		<button>수정하기</button>
	</form>
</body>
</html>