<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		//response.getWriter().write("<script>alert('안녕하세요')</script>");
		//url 변경으로 페이지 이동
		//response.getWriter().write("<script>location.href='forwardResult.jsp'</script>");
	%>
	<%=request.getParameter("name") %><br>
	<%=request.getParameter("hobby") %><br>
	<!-- url 변경 없이 페이지 이동  -->
	<jsp:forward page="forwardResult.jsp"></jsp:forward>
