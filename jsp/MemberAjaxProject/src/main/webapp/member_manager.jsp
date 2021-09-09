<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	width: 1400px;
	margin: 0 auto;
}
h1{
	text-align: center;
}

.item {
	width: 100%;
	display: flex;
	flex-direction: row;
	justify-content: center;
	margin-top: 10px;
	text-align: center
}
.frm{
	width: 1400px;
	margin: 0 auto;
	display: flex;
	flex-direction: row;
	justify-content: center;
	text-align: center
}
</style>
<script src="resource/jquery-3.5.1.min.js"></script>
<script>
	/*
		등록 버튼을 누르면 insertMember.do를 호출해서 입력한 회원 정보를 등록
		회원 목록을 최신화 결과를 Ajax로 받아서 처리	
	*/
	$(function() {
		$("#btnRegister").click(function(){
			var d = $(".frm").serialize();
			$.ajax({
				url : "insertMember.do",
				data : d,
				type : "post",
				dataType:"json",
				success : function(r) {
					//결과값을 받는 부분	
					var str = "";
					for(i=0;i<r.length;i++){
						str += "<div class='item'>";
						str += "<input type='text' name='id' value='"+r[i].id+"' placeholder='아이디'>";
						str += "<input type='password' name='passwd' value='"+r[i].passwd+"' placeholder='암호'>"
						str += "<input type='text' name='name' value='"+r[i].name+"' placeholder='이름'>" 
						str += "<input type='text'name='age' value='"+r[i].age+"' placeholder='나이'>" 
						str += "<select	name='gender'>"
						str += 	"<option value='0' "+(r[i].gender == "0" ? "selected" : "")+">남</option>"
						str += 	"<option value='1' "+(r[i].gender == "1" ? "selected" : "")+">여</option>"
						str += "</select> "
						str += "<input type='text' name='point' value='"+r[i].point+"' placeholder='포인트'>" 
						str += "<input type='text' name='grade' value='"+r[i].grade+"' placeholder='등급'>"
						str += "</div>";
					}
					$(".container").html(str);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>회원 관리 페이지</h1>
	<form class="frm">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="passwd" placeholder="암호">
		<input type="text" name="name" placeholder="이름"> 
		<input type="text"name="age" placeholder="나이"> 
		<select	name="gender">
			<option value="0">남</option>
			<option value="1">여</option>
		</select> 
		<input type="text" name="point" placeholder="포인트"> 
		<input type="text" name="grade" placeholder="등급">
		<button type="button" id="btnRegister">등록</button>
	</form>
	<hr>
	<div class="container">
		<c:forEach var="member" items="${requestScope.list }">
			<div class="item">
				<input type="text" name="id" value="${member.id }" placeholder="아이디">
				<input type="password" name="passwd" value="${member.passwd }"
					placeholder="암호"> <input type="text" name="name"
					value="${member.name }" placeholder="이름"> <input
					type="text" name="age" value="${member.age }" placeholder="나이">
				<select name="gender">
					<option value="0"
						<c:if test="${member.gender == '0' }">selected</c:if>>남</option>
					<option value="1"
						<c:if test="${member.gender == '1' }">selected</c:if>>여</option>
				</select> <input type="text" name="point" value="${member.point }"
					placeholder="포인트"> <input type="text" name="grade"
					value="${member.grade }" placeholder="등급">
			</div>
		</c:forEach>
	</div>
</body>
</html>






