<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="register.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하세요"><br>
		<input type="password" name="pass" placeholder="암호를 입력하세요"><br>
		<input type="text" name="name" placeholder="이름을 입력하세요"><br>
		<input type="text" name="age" placeholder="나이를 입력하세요"><br>
		<input type="radio" name="gender" value="1">남
		<input type="radio" name="gender" value="0">여<br>
		<button>가입하기</button>  
	</form>
</body>
</html>