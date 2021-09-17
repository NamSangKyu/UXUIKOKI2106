<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		var count = 3;
		$("#plus").click(function() {
			if(count==5) return;
			count++;
			$("form").append("<p><input type='file' name='file'></p>");
		});
		$("#minus").click(function() {
			if(count==1) return;
			count--;
			$("form").children("p").last().remove();
		});
	});
</script>
</head>
<body>
	<c:if test="${sessionScope.client == null }">
		<script>
			alert("로그인 후 이용하세요");
			location.href="/";
		</script>
	</c:if>
	<h2>글쓰기 페이지</h2>
	<form action="boardWrite.do" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title" placeholder="제목을 입력하세요">
		<br>내용
		<textarea name="content" placeholder="내용을 입력하세요"></textarea>
		<hr>
		<p>
			<input type="file" name="file">
			<button type="button" id="plus">+</button>
			<button type="button" id="minus">-</button>
		</p>
		<p><input type="file" name="file">	</p>
		<p><input type="file" name="file">	</p>
		<button>글쓰기</button>
	</form>
</body>
</html>









