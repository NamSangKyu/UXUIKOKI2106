<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- action 전달할 서버페이지 : 서블릿의 @WebServlet("경로")와 일치 -->

	<form action="test.do">
		<input type="text" name="param"><button>전송</button>
	</form>
</body>
</html>