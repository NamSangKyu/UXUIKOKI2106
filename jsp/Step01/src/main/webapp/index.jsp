<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style>
	header{
		width: 1200px;
		height: 300px;
		border:1px solid black;
		margin:0 auto;
	}
	section{
		width: 1200px;
		height: 500px;
		border:1px solid blue;
		margin:0 auto;
	}
	footer{
		width: 100%;
		height: 200px;
		border:1px solid green;
	}
	
</style>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<section>본문 영역</section>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>








