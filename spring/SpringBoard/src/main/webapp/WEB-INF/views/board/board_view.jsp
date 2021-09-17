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
	제목 : ${requestScope.board.title }<br>
	작성자 : ${requestScope.board.writer}, 작성일 : ${requestScope.board.bdate}<br>
	조회수 : ${requestScope.board.bcount}<br>
	내용<br> ${requestScope.board.content}
	<hr>
	첨부파일 목록<br>
	<!-- 파일 링크 출력 -->
	<c:forEach var="f" items="${requestScope.flist }">
		첨부파일 : <a href="fileDownload.do?fno=${f.fno }">${f.originFileName }</a><br>
	</c:forEach>
	<hr>
	<button type="button" class=".btnBack">뒤로가기</button>
	<button type="button" class=".btnUpdate">수정</button>
	<button type="button" class=".btnDeletet">삭제</button>
</body>
</html>








