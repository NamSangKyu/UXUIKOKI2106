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
		request.setAttribute("req", "request value");
		
		//세션 설정
		//세션 만료 시간 설정
		session.setMaxInactiveInterval(30);//초단위
		session.setAttribute("session", "session value");
		
		//페이지 이동 - 1 forward
		/* request.getRequestDispatcher("session_result.jsp")
										.forward(request,response); */
		
		//페이지 이동 - 2 sendRedirect
		response.sendRedirect("session_result.jsp");
	%>
</body>
</html>




