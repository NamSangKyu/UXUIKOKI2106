<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%MemberDTO dto = (MemberDTO)request.getAttribute("obj"); %>
	<form action="update.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하세요" value="<%=dto.getId()%>" readonly><br>
		<input type="text" name="name" placeholder="이름을 입력하세요" value="<%=dto.getName()%>"><br>
		<input type="text" name="age" placeholder="나이를 입력하세요" value="<%=dto.getAge()%>"><br>
		<input type="radio" name="gender" value="1" <%=dto.getGender().equals("1") ? "checked" : "" %>>남
		<input type="radio" name="gender" value="0" <%=dto.getGender().equals("0") ? "checked" : "" %>>여<br>
		<input type="text" name="point" placeholder="포인트를 입력하세요" value="<%=dto.getPoint()%>"><br>
		등급 : <select name="grade">
			<option value="Bronze" <%=dto.getGrade().equals("Bronze") ? "selected" : ""%>>Bronze</option>
			<option value="Silver" <%=dto.getGrade().equals("Silver") ? "selected" : ""%>>Silver</option>
			<option value="Gold" <%=dto.getGrade().equals("Gold") ? "selected" : ""%>>Gold</option>
			<option value="DIAMOND" <%=dto.getGrade().equals("DIAMOND") ? "selected" : ""%>>DIAMOND</option>
			<option value="VIP" <%=dto.getGrade().equals("VIP") ? "selected" : ""%>>VIP</option>
			<option value="VVIP" <%=dto.getGrade().equals("VVIP") ? "selected" : ""%>>VVIP</option>
		</select>
		
		<button>정보수정</button>
		<button type="button">취소</button>  
	</form>
</body>
</html>