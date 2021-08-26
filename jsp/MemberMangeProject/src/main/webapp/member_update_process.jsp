<%@page import="dto.MemberDTO"%>
<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	int point = Integer.parseInt(request.getParameter("point"));
	String grade = request.getParameter("grade");
	
	int count = MemberService.getInstance().updateMember(new MemberDTO(id,null,name,age,gender,point,grade));
	
	if(count == 1){
		response.sendRedirect("main.jsp");
	}else{
		%>
		<script>
			history.back();
		</script>
		<%
	}
%>