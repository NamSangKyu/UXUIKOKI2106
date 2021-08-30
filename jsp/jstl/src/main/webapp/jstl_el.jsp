<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el 태그 테스트</h2>
	<p>request에 저장된 내용은 requestScore를 사용하여 뽑음</p>
	<p>age : ${requestScope.age }</p>
	<p>session에 저장된 내용은 seesionScore를 사용하여 뽑음</p>
	<p>age : ${sessionScope.msg }</p>
	<p>객체 읽기</p>
	<p>${requestScope.dto.id },${requestScope.dto.pass },${requestScope.dto.name }
	 	${requestScope.age * 2}
	</p>
	<p>${requestScope.dto.toString()},</p>
	<h2>jstl 테스트</h2>
	<p>set, out</p>
	<p><c:set var="tnum" value="1000"/></p>
	<p><c:out value="${tnum }"/>,
	<c:out value="${sessionScope.msg }" /></p>
</body>
</html>








