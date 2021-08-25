<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function(){
			//폼 태그에 있는 input 태그에 입력한 내용을 전부 쿼리스트링으로 자동으로 생성
			var data = $("#frm").serialize();
			$.ajax({
				
			});
		})
	});
</script>
</head>
<body>
	<form id="frm">
		<input type="text" name="name">
		<button type="button">검색</button>
	</form>
	<div id="result"></div>
</body>
</html>





