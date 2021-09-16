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
	<c:if test="${sessionScope.client != null }">
		<c:redirect url="boardList.do"/>
	</c:if>
	<form action="login.do">
		<input type="text" name="id" placeholder="아이디를 입력하세요"><br>
		<input type="password" name="pass" placeholder="암호를 입력하세요"><br>
		<button>로그인</button>
		<button type="button" class="btnRegister">회원가입</button>
	</form>
<script type="text/javascript">
	document.querySelector(".btnRegister").onclick = function(){
		location.href = "registerView.do";
	}	
</script>
</body>
</html>









