<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
<style type="text/css">
	table{
		border-collapse: collapse;
		margin:0 auto;
	}
	th, td{
		padding:5px 10px;
		text-align: center;
		font-size: 1.3rem;
	}
</style>
</head>
<body>
	<a href="memberUpdateView.do">${sessionScope.client.id }</a>님이 로그인하셨습니다.<br>
	<a href="logout.do">로그아웃</a>
	<hr>
	<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
		<th>조회수</th>
		<th>좋아요</th>
		<th>싫어요</th>
	</tr>
	<c:forEach var="board" items="${requestScope.list }">
	<tr>
		<td>${board.bno }</td>
		<td>${board.title }</td>
		<td>${board.writer }</td>
		<td>${board.bdate }</td>
		<td>${board.bcount }</td>
		<td>${board.blike }</td>
		<td>${board.bhate }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>