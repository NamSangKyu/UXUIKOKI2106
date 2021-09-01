<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록</title>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	th,td{
	border :1px solid black;
	text-align: center;
	padding:5px 20px;
	}
	table{
		border-collapse: collapse;
		margin:0 auto;
		
	}
	h1{
		text-align: center;
	}
	.footer{
	text-align: right;
	}
</style>
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
				<th><a href="boardList.do?order=bcount">조회수</a></th>
				<th><a href="boardList.do?order=blike">좋아요</a></th>
				<th><a href="boardList.do?order=bhate">싫어요</a></th>
			</tr>
			<c:forEach var="board" items="${requestScope.list}" >
				<tr>
					<td>${board.bno }</td>
					<td><a href="boardView.do?bno=${board.bno }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.bdate }</td>
					<td>${board.bcount }</td>
					<td>${board.blike }</td>
					<td>${board.bhate }</td>
				</tr>
			</c:forEach>	
			<tr>
			<td colspan="7" class="footer">
				<a href="boardWriteView.do">글쓰기</a>
			</tr>
		</table>
	</div>
</body>
</html>




