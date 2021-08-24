<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward 액션 태그</h2>
	<form action="forwardTest.jsp">
		이름 : <input type="text" name="name"><br>
		취미 : <select name="hobby">
			<option value="게임">게임</option>
			<option value="영화감상">영화감상</option>
			<option value="낚시">낚시</option>
			<option value="등산">등산</option>
		</select>
		<button>전송</button>
	</form>
</body>
</html>