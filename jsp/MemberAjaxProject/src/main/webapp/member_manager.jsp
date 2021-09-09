<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.container{
		width:1400px;
		margin:0 auto;
	}
	.item{
		width:100%;
		display: flex;
		flex-direction: row;
		justify-content: center;
	}
</style>
</head>
<body>
	<h1>회원 관리 페이지</h1>
	<hr>
	<div class="container">
		<c:forEach var="member" items="${requestScope.list }">
			<div class="item">
				<input type="text" name="id" value="${member.id }" placeholder="아이디">
				<input type="password" name="passwd" value="${member.passwd }" placeholder="암호">
				<input type="text" name="name" value="${member.name }" placeholder="이름">
				<input type="text" name="age" value="${member.age }" placeholder="나이">
				<select name="gender">
					<option value="0" <c:if test="${member.gender == '0' }">selected</c:if>>남</option>
					<option value="1" <c:if test="${member.gender == '1' }">selected</c:if>>여</option>
				</select>
				<input type="text" name="point" value="${member.point }" placeholder="포인트">
				<input type="text" name="grade" value="${member.grade }" placeholder="등급">
			</div>
		</c:forEach>
	</div>
</body>
</html>






