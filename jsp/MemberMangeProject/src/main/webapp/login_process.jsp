<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("admin") && pass.equals("123456")){
		session.setAttribute("id", id);
		session.setAttribute("nick", "관리자");
	%>
		<script>
			alert("<%=id%>님 로그인 성공");
			location.href="main.jsp";
		</script>
	<%	
	}else{
		%>
		<script>
			alert('로그인 실패, 아이디와 비밀번호 확인하세요');
			history.back();
		</script>			
		<%
	}
%>