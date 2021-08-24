<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 로그인 페이지</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
input{
	width: 300px;
	height: 60px;
	font-size: 24px;
	box-sizing: border-box;
}
button{
width: 150px;
height: 60px;
font-size:20px;
}
.container {
	width:300px;
	margin:100px auto;
}
h2{
	text-align: center;
margin-bottom: 10px; 
}
form {
font-size :0px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>로그인 페이지</h2>
		<form action="login_process.jsp" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요"><br>
			<input type="password" name="pass" placeholder="암호를 입력하세요"><br>
			<button>로그인</button>
			<button type="button">회원가입</button>
		</form>
	</div>
</body>
</html>






