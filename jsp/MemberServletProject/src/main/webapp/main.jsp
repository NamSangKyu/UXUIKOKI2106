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
<script src="resource/lib/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("section button").click(function() {
			var data = $("form").serialize();
			$.ajax({
				data:data,
				type:"get",
				dataType:"json",
				url:"search_process.jsp",
				success:function(r){
					console.log(r);
					var tag = "";
					for(i=0;i<r.length;i++){
						tag += "<tr>";
						tag += "<td>"+r[i].id+"</td>";
						tag += "<td>"+r[i].name+"</td>";
						tag += "<td>"+r[i].age+"</td>";
						tag += "<td>"+r[i].gender+"</td>";
						tag += "<td>"+r[i].point+"</td>";
						tag += "<td>"+r[i].grade+"</td>";
						tag += "<td><a href='update_view.jsp?id="+r[i].id+"'>수정</a><a href=\"#\">삭제</a></td>";
						tag += "</tr>";
					}
					$(".content").html(tag);
				}
			});
		});
	});
</script>
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
		<!-- search bar start -->
		<!-- 
			이름을 입력해서 입력 값 일부와 동일한 데이터를 .content에 출력
			ajax를 이용해서 결과값을 출력
			
			1. 검색어 받을 폼
			2. ajax 처리
			3. process 작업
				1. 사용자가 보낸 데이터를 받아서
				2. DB 조회해서 리스트로 받고
				3. json 조립 후 클라이언트에게 전송
			4. success부분의 함수에서 출력
			--추가 작업
			1. 기존은 이름으로 검색 -> search bar를 아이디, 이름, 등급중에 하나 선택해서 검색을 하게끔 변경 
		 -->
		<!-- search bar end -->
		<div>
			<form>
				<select name="kind">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="grade">등급</option>
				</select><input type="text" name="search"><button type="button">검색</button>
			</form>
		</div>
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
				ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)session.getAttribute("list");
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getName() %></td>
						<td><%=list.get(i).getAge() %></td>
						<td><%=list.get(i).getGender().equals("0") ? "여" : "남" %></td>
						<td><%=list.get(i).getPoint() %></td>
						<td><%=list.get(i).getGrade() %></td>
						<td><a href="update_view.jsp?id=<%=list.get(i).getId()%>">수정</a><a href="member_delete_process.jsp?id=<%=list.get(i).getId()%>">삭제</a></td>
					</tr>
					<%
				}
			%>
			</tbody>
		</table>
	</section>
	
	
</body>
</html>



