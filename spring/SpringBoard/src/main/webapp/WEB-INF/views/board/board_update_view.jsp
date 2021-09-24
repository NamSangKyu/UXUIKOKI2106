<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
</head>
<body>
	<c:if test="${sessionScope.client == null }">
		<script>
			alert("로그인 후 이용하세요");
			location.href="/";
		</script>
	</c:if>
	<h2>게시글 수정</h2>
	<form action="boardUpdate.do" method="post">
		제목 : <input type="text" name="title" value="${requestScope.board.title}"><br>
		작성일 : ${requestScope.board.bdate}<br>
		작성자 : ${requestScope.board.writer}
		내용<br>
		<textarea name="content">${requestScope.board.content}</textarea>
		<br>
		<button>수정</button>
		<button type="button" onclick="history.back();">취소</button>
		<input type="hidden" name="bno" value="${requestScope.board.bno}">
	</form>
</body>
</html>









