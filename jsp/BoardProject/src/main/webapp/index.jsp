<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		<input type="text" name="id" placeholder="아이디 입력"><br>
		<input type="password" name="pass" placeholder="암호를 입력"><br>
		<button>로그인</button>
		<button type="button">회원가입</button>
		
	</form>
	<a href="boardList.do">게시판으로 이동</a>
</body>
</html>