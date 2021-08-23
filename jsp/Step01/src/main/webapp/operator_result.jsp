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
		String n1 = request.getParameter("n1");
		String op = request.getParameter("op");
		String n2 = request.getParameter("n2");
		int result = 0;
		switch(op){
		case "+":
			result = Integer.parseInt(n1) + Integer.parseInt(n2);
			break;
		case "-":
			result = Integer.parseInt(n1) - Integer.parseInt(n2);
			break;
		case "/":
			result = Integer.parseInt(n1) / Integer.parseInt(n2);
			break;
		case "%":
			result = Integer.parseInt(n1) % Integer.parseInt(n2);
			break;
		default:
			result = Integer.parseInt(n1) * Integer.parseInt(n2);
			
		}

	%>
	<p>계산 결과 : <%=result %></p>
</body>
</html>










