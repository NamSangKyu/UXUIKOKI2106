<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDTO"%>
<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
	margin:0;
	padding:0;
	}
	
	section{
		width:1200px;
		margin:40px auto;
	}
	table{
		border-collapse: collapse;
		width:100%;
	}
	td,th{
		border :1px solid black;
		padding:10px 0px;
		text-align: center;
	}
	
	
</style>
</head>
<body>
	<%
	MemberDTO dto =(MemberDTO)session.getAttribute("obj");
		
	%>
	<style>
		header{
			width : 1200px;
			border-bottom : 2px solid black;
			text-align: right;
			margin:0 auto;
		}
		.profile{
			width:320px;
			display:inline-block;
		}
		.profile > img {
			height: 50px;
			float:left;
		}
		.profile > p {
			width:250px;
			height:50px;
			text-align:left;
			padding-left : 5px;
			float:left;
		}
	</style>
	<header>
		<div class="profile">
			<img src="resource/profile.png">
			<p><%=dto.getName() %>님 로그인 하셨습니다.<br>
				<a href="logout_process.jsp">로그아웃</a></p>
		</div>
	</header>	
	<section>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>포인트</th>
					<th>등급</th>
					<th>작업</th>
				</tr>
			</thead>
			<tbody class="content">
			<%
				ArrayList<MemberDTO> list = MemberService.getInstance().selectAllMember();
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getName() %></td>
						<td><%=list.get(i).getAge() %></td>
						<td><%=list.get(i).getGender().equals("0") ? "여" : "남" %></td>
						<td><%=list.get(i).getPoint() %></td>
						<td><%=list.get(i).getGrade() %></td>
						<td><a href="#">수정</a><a href="#">삭제</a></td>
					</tr>
					<%
				}
			%>
			</tbody>
		</table>
	</section>
	
	
</body>
</html>



