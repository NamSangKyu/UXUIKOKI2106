<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//request 객체에 데이터를 저장
		request.setAttribute("key", "data");
	%>
	<!--하이퍼 링크 / submit는 request 객체가 초기화 setAttribute한 내용이 전달X-->
	<a href="request_attribute_result.jsp">페이지 이동</a>
	<form action="request_attribute_result.jsp">
		<button>전송</button>
	</form>
</body>
</html>