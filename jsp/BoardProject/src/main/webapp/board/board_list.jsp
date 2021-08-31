<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록</title>
</head>
<body>
	<h1>게시판 글목록</h1>
	<div class="container">
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>
			<c:forEach var="board" items="${requestScope.list}" >
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
		<a href="board/board_write.jsp">글쓰기</a>
	</div>
</body>
</html>