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
	<p>${requestScope.dto.id },${requestScope.dto.pass },${requestScope.dto.name },	${requestScope.age * 2}	</p>
	<p>${requestScope.dto.toString()},</p>
	<h2>jstl 테스트</h2>
	<p>set, out</p>
	<!-- set : 변수 만들어서 데이터 초기화 -->
	<p><c:set var="tnum" value="1000"/></p>
	<!-- out : 해당 데이터를 출력 -->
	<p><c:out value="${tnum }"/>,
	<c:out value="${sessionScope.msg }" /></p>
	<!-- if문 test가 조건식, 단 else if나 else 는 없음 -->
	<p>if문</p>
	<c:if test="${requestScope.age < 20 }">
		<p>미성년자 입니다.</p>
	</c:if>
	<p>여러개 조건문</p>
	<c:choose>
		<c:when test="${requestScope.age < 11 }">
			<p>10세 미만 아동입니다.</p>
		</c:when>
		<c:when test="${requestScope.age < 20 }">
			<p>10대 어린이 입니다.</p>
		</c:when>
		<c:otherwise>
			<p>성인 입니다.</p>
		</c:otherwise>
	</c:choose>
	<p>반복문 - 숫자 설정해서 출력</p>
	<ul>
		<c:forEach var="i" begin="1" end="10">
			<li>${i}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" begin="1" end="10" step="2">
			<li>${i}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="m" items="${requestScope.list }">
			<li>${m.toString() }</li>
		</c:forEach>
	</ul>
	
</body>
</html>








