<%@page import="service.MemberService"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	//DB 적용해서 처리 - 변경
	//MemberService, MemberDAO 추가 해서 실행
	//session에는 회원 정보를 저장 MemberDTO를 저장
	MemberDTO dto = MemberService.getInstance().login(id, pass);
	
	if(dto != null){
		session.setAttribute("obj", dto);
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