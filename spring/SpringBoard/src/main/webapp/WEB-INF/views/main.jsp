<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do">
		<input type="text" name="id" placeholder="아이디를 입력하세요"><br>
		<input type="password" name="pass" placeholder="암호를 입력하세요"><br>
		<button>로그인</button>
		<button type="button" class="btnRegister">회원가입</button>
	</form>
<script type="text/javascript">
	document.querySelector(".btnRegister").click = function(){
		location.href = "registerView.do";
	}	
</script>
</body>
</html>









