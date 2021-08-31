<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 수정</h2>
	<form action="boardUpdate.do" method="post">
		제목 : <input type="text" name="title" value="${requestScope.board.title}"><br>
		작성일 : ${requestScope.board.bdate}<br>
		작성자 : ${requestScope.board.writer}
		내용<br>
		<textarea name="content">${requestScope.board.content}</textarea>
		<br>
		<button>글쓰기</button>
		<button type="button">취소</button>
		<input type="hidden" name="bno" value="${requestScope.board.bno}">
	</form>
</body>
</html>



