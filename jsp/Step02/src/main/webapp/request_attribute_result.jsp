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
		request.setAttribute("name", "홍길동");
		request.setAttribute("age", "20");
		
		//페이지 이동 1 - 계속해서 사용자의 응답을 받아야 될때
		//이동할 페이지 설정
		/* RequestDispatcher dispatcher =
			request.getRequestDispatcher("request_final_result.jsp");
		dispatcher.forward(request, response);//이 순간 페이지 이동 */
		//페이지 이동 2 - 사용자의 응답 및 요청이 필요 없을때 request 객체가 초기화
		response.sendRedirect("request_final_result.jsp");
	
	%>
</body>
</html>







