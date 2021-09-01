<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".btnBack").click(function () {
			history.back();
		});
		
	});
</script>
</head>
<body>
	<c:if test="${sessionScope.obj == null }">
		<script type="text/javascript">
			alert("로그인하셔야 이용할수 있습니다.");
			location.href = "${pageContext.request.contextPath}/index.jsp";
		</script>
	</c:if>
	<h2>글쓰기</h2>
	<form action="boardWrite.do" method="post">
		제목 : <input type="text" name="title"><br>
		내용<br>
		<textarea name="content"></textarea><br>
		<button>글쓰기</button><button type="button" class="btnBack">취소</button>
													<!-- session.getAttribute("obj").getId() -->
		<input type="hidden" name="writer" value="${sessionScope.obj.id }">
	</form>
</body>
</html>