<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
</head>
<body>
	<h1>관리자 메인 페이지</h1>
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
				<td><a href="qnaAdminView.do?qno=${obj.qno}">${obj.qcontent}</a></td>
				<td>${obj.qdate}</td>
				<td>${obj.qwriter}</td>
				<td>
					<c:choose>
					<c:when test="${obj.status=='0'}">
						읽지 않음
					</c:when>					
					<c:when test="${obj.status=='1'}">
						읽음
					</c:when>					
					<c:when test="${obj.status=='2'}">
						답변 보류
					</c:when>
					<c:otherwise>
						답변완료
					</c:otherwise>					
					</c:choose>
				</td>
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
</body>
</html>