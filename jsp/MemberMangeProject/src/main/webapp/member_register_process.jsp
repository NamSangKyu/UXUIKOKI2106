<%@page import="dto.MemberDTO"%>
<%@page import="service.MemberService"%>
<%@page import="config.DBManager"%>
<%@page import="config.DBConfig"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	System.out.println(name);
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	
	int result = MemberService.getInstance().insertMember(new MemberDTO(id,pass,name,age,gender,0,null));
	if(result == 1){
		//index.jsp로 이동
		%>
			<script>
				location.href = "index.jsp";
			</script>		
		<%
	}else{
		//뒤로가기
		%>
			<script>
				alert("회원가입에 실패하였습니다.");
				history.back();
			</script>
		<%
	}
%>








