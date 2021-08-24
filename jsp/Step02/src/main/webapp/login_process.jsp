<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	if(id.equals("admin") && pass.equals("1234")){
		%>
		<jsp:forward page="login_success.jsp"></jsp:forward>
		<script>
			location.href = "login_success.jsp";
		</script>
		<%
	}else{
		%>
		<%-- <jsp:forward page="login_fail.jsp"></jsp:forward> --%>
		<script>
			/* location.href = "login_fail.jsp"; */
			alert("아이디와 비번을 확인하세요");
			history.back();
		</script>
		<%
	}
%>