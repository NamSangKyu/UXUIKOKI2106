<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 메인</title>
</head>
<body>
	<h1>사용자 메인</h1>
	<!-- 본인 문의 목록 -->
	<table>
		<tr>
			<th>문의번호</th>
			<th>문의내용</th>
			<th>문의날짜</th>
			<th>작성자</th>
			<th>답변상태</th>
		</tr>
		<c:if test="${list.size()==0 }">
			<tr>
			<td colspan="5">문의 내용이 없습니다</td>
			</tr>
		</c:if>
		<c:forEach var="obj" items="${sessionScope.list }">
			<tr>
				<td>${obj.qno}</td>
				<td>${obj.qcontent}</td>
				<td>${obj.qdate}</td>
				<td>${obj.qwriter}</td>
				<td>${obj.status}</td>
			</tr>
			<c:if test="${obj.status=='3' }">
			<tr>
				<td></td>
				<td>${obj.acontent }</td>
				<td>${obj.awriter }</td>
				<td>${obj.adate }</td>
			</tr>
			</c:if>
		</c:forEach>		 
	</table>
	<hr>
	<!-- 문의하기 폼 -->
	<form action="qnaWrite.do" method="post">
		<textarea name="content"></textarea><button>전송</button>
		<input type="hidden" name="qwriter" value="${sessScope.dto.id }">	
	</form>
</body>
</html>




