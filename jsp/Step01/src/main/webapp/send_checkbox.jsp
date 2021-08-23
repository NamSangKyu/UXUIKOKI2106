<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="checkbox_result.jsp" method="get">
		<p>취미생활 선택</p>
		<input type="checkbox" name="hobby" value="game">게임<br>
		<input type="checkbox" name="hobby" value="movie">영화감상<br>
		<input type="checkbox" name="hobby" value="hiking">등산<br>
		<input type="checkbox" name="hobby" value="health">운동<br>
		<input type="checkbox" name="hobby" value="fishing">낚시<br>
		<input type="checkbox" name="hobby" value="riding">자전거<br>
		<input type="checkbox" name="hobby" value="read">독서<br>
		<button>취미 전송</button>
		
	</form>
</body>
</html>