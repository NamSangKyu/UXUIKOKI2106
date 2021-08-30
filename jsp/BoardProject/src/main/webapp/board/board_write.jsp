<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="boardWrite.do" method="post">
		제목 : <input type="text" name="title"><br>
		내용<br>
		<textarea name="content"></textarea><br>
		<button>글쓰기</button><button type="button">취소</button>
		<input type="hidden" name="writer" value="A0001">
	</form>
</body>
</html>