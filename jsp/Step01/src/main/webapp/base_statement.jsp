<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 기본 문법</title>
</head>
<body>
<!-- 선언문 -->
<%!
	//필드
	String message = "Hello World";
	//메서드
	public String getMessage(){
		return message;
	}

%>
<!-- 표현식, 화면에 값을 출력하는 부분 -->
선언문 필드 테스트 : <%=message %><br>
선언문 메서드 테스트 : <%=getMessage() %><br>

<!-- 스크립트릿, 사용자가 서버에 데이터를 전달, 실제 jsp에서 일을 하는 부분 -->
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String str = request.getParameter("msg");
%>

스크립트릿 테스트 : <%= num %><br>
스크립트릿 테스트 : <%= str %><br>


</body>
</html>







