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
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			%>
				<%=cookies[i].getName() %> :<%=cookies[i].getValue() %><br>  
			<%
		}
	%>
	<%=session.getId() %><br>
	<a href="cookie_setting.jsp">쿠기 생성 페이지 이동</a>	
</body>
</html>






