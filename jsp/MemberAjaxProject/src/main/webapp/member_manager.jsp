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
.dialog{
	width: 200px;
	height: 200px;
	box-shadow: 0px 0px 5px black;
	position:fixed;
	top : 20px;
	right: 50px;
	background-color: white;
	display: none;
	color:skyblue;
	font-weight: bold;
	font-size:20px;
	padding:20px;
	text-align: center;
}
.form_container{
	text-align: center;
}
</style>
<script src="resource/jquery-3.5.1.min.js"></script>
<script>
	function deleteAction() {
		//alert($(this).siblings("input[name=id]").val());
		var id = $(this).siblings("input[name=id]").val();
		$.ajax({
			url : "deleteMember.do",
			data : "id="+id,
			type:"post",
			dataType:"json",
			success:function(r){
				//결과값을 받는 부분	
				var str = "";
				for(i=0;i<r.length;i++){
					str += "<div class='item'>"
					str += "<input type='text' name='id' value='"+r[i].id+"' placeholder='아이디'>"
					str += "<input type='password' name='passwd' value='"+r[i].passwd+"' placeholder='암호'>"
					str += "<input type='text' name='name' value='"+r[i].name+"' placeholder='이름'>" 
					str += "<input type='text'name='age' value='"+r[i].age+"' placeholder='나이'>" 
					str += "<select	name='gender'>"
					str += 	"<option value='0' "+(r[i].gender == "0" ? "selected" : "")+">남</option>"
					str += 	"<option value='1' "+(r[i].gender == "1" ? "selected" : "")+">여</option>"
					str += "</select> "
					str += "<input type='text' name='point' value='"+r[i].point+"' placeholder='포인트'>" 
					str += "<input type='text' name='grade' value='"+r[i].grade+"' placeholder='등급'>"
					str += "<button class='btnUpdate'>수정</button><button class='btnDelete'>삭제</button>"
					str += "</div>"
				}
				$(".container").html(str);
				//추가된 새 엘리먼트들이 이벤트 처리 부분 추가
				$(".btnDelete").click(deleteAction);
				$(".btnUpdate").click(updateAction);
				$(".dialog").slideDown(500,function(){
					$(this).html("회원등록이 정상적으로 수행되었습니다.");
				
					//3초 뒤에 해당 알림창을 자동으로 사라지게끔 처리
					setTimeout(() => {
						$(".dialog").slideUp(500);
					}, 3000);
				});
			}
		});
	}
	function updateAction(){
		//현재 클릭한 버튼 기준으로 부모 태그 선택 후 그 부모태그를 form 태그로 묶음
		$(this).parent().wrap("<form></form>");
		//alert($(this).parents("form").serialize());
		var d = $(this).parents("form").serialize()
		$.ajax({
			url : "updateMember.do",
			data : d,
			type : "post",
			dataType:"json",
			success : function(r) {
				//결과값을 받는 부분	
				var str = "";
				for(i=0;i<r.length;i++){
					str += "<div class='item'>"
					str += "<input type='text' name='id' value='"+r[i].id+"' placeholder='아이디'>"
					str += "<input type='password' name='passwd' value='"+r[i].passwd+"' placeholder='암호'>"
					str += "<input type='text' name='name' value='"+r[i].name+"' placeholder='이름'>" 
					str += "<input type='text'name='age' value='"+r[i].age+"' placeholder='나이'>" 
					str += "<select	name='gender'>"
					str += 	"<option value='0' "+(r[i].gender == "0" ? "selected" : "")+">남</option>"
					str += 	"<option value='1' "+(r[i].gender == "1" ? "selected" : "")+">여</option>"
					str += "</select> "
					str += "<input type='text' name='point' value='"+r[i].point+"' placeholder='포인트'>" 
					str += "<input type='text' name='grade' value='"+r[i].grade+"' placeholder='등급'>"
					str += "<button class='btnUpdate'>수정</button><button class='btnDelete'>삭제</button>"
					str += "</div>"
				}
				$(".container").html(str);
				$(".btnDelete").click(deleteAction);
				$(".btnUpdate").click(updateAction);
				$(".dialog").slideDown(500,function(){
					$(this).html("회원등록이 정상적으로 수행되었습니다.");
				
					//3초 뒤에 해당 알림창을 자동으로 사라지게끔 처리
					setTimeout(() => {
						$(".dialog").slideUp(500);
					}, 3000);
				});
			}
		});
	}
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
						str += "<div class='item'>"
						str += "<input type='text' name='id' value='"+r[i].id+"' placeholder='아이디'>"
						str += "<input type='password' name='passwd' value='"+r[i].passwd+"' placeholder='암호'>"
						str += "<input type='text' name='name' value='"+r[i].name+"' placeholder='이름'>" 
						str += "<input type='text'name='age' value='"+r[i].age+"' placeholder='나이'>" 
						str += "<select	name='gender'>"
						str += 	"<option value='0' "+(r[i].gender == "0" ? "selected" : "")+">남</option>"
						str += 	"<option value='1' "+(r[i].gender == "1" ? "selected" : "")+">여</option>"
						str += "</select> "
						str += "<input type='text' name='point' value='"+r[i].point+"' placeholder='포인트'>" 
						str += "<input type='text' name='grade' value='"+r[i].grade+"' placeholder='등급'>"
						str += "<button class='btnUpdate'>수정</button><button class='btnDelete'>삭제</button>"
						str += "</div>"
					}
					$(".container").html(str);
					$(".btnDelete").click(deleteAction);
					$(".btnUpdate").click(updateAction);
					$(".dialog").slideDown(500,function(){
						$(this).html("회원등록이 정상적으로 수행되었습니다.");
					
						//3초 뒤에 해당 알림창을 자동으로 사라지게끔 처리
						setTimeout(() => {
							$(".dialog").slideUp(500);
						}, 3000);
					});
				},
				error:function(xhr, textStatus, errorThrow){
					/* console.log(xhr);
					console.log(textStatus);
					console.log(errorThrow);
					//실제 에러는 xhr.status 상태값을 받음 , 200이면 정상수행 그외에는 에러
					//xhr.responseText 에러메세지
					*/
					var msg = "";
					switch(xhr.status){
					case 1001:
						msg = "포인트와 나이에는 숫자만 입력하세요";
						break;
					}
					$(".dialog").slideDown(500,function(){
						
						$(this).html(msg);
					
						//3초 뒤에 해당 알림창을 자동으로 사라지게끔 처리
						setTimeout(() => {
							$(".dialog").slideUp(500);
						}, 3000);
					});
					
				}
			});
		});
		//동적 엘리먼트 이벤트 처리를 위해 삭제하는 함수를 외부로 별로도 선언
		//이벤트 처리후 동적엘리먼트에 이벤트 추가를 위해 해당 이벤트 처리를 deleteAction ajax 마지막 처리부분에 추가
		$(".btnDelete").click(deleteAction);
		$(".btnUpdate").click(updateAction);
		//검색처리
		$("#btnSearch").click(function() {
			var d = $(this).parent().serialize();
			
			$.ajax({
				url:"search.do",
				data:d,
				type:"post",
				dataType:"json",
				success:function(r){
					var str = "";
					for(i=0;i<r.length;i++){
						str += "<div class='item'>"
						str += "<input type='text' name='id' value='"+r[i].id+"' placeholder='아이디'>"
						str += "<input type='password' name='passwd' value='"+r[i].passwd+"' placeholder='암호'>"
						str += "<input type='text' name='name' value='"+r[i].name+"' placeholder='이름'>" 
						str += "<input type='text'name='age' value='"+r[i].age+"' placeholder='나이'>" 
						str += "<select	name='gender'>"
						str += 	"<option value='0' "+(r[i].gender == "0" ? "selected" : "")+">남</option>"
						str += 	"<option value='1' "+(r[i].gender == "1" ? "selected" : "")+">여</option>"
						str += "</select> "
						str += "<input type='text' name='point' value='"+r[i].point+"' placeholder='포인트'>" 
						str += "<input type='text' name='grade' value='"+r[i].grade+"' placeholder='등급'>"
						str += "<button class='btnUpdate'>수정</button><button class='btnDelete'>삭제</button>"
						str += "</div>"
					}
					$(".container").html(str);
					$(".btnDelete").click(deleteAction);
					$(".btnUpdate").click(updateAction);
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
	<div class="form_container">
		<form>
			<select name="kind">
				<option value="id">아이디</option>
				<option value="name">이름</option>
				<option value="grade">등급</option>
				<option value="gender">성별</option>
			</select>
			<input type="text" name="search" placeholder="검색어를 입력하세요">
			<button type="button" id="btnSearch">검색</button>
		</form>
	</div>
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
					<button class="btnUpdate" type="button">수정</button>
					<button class="btnDelete">삭제</button>
			</div>
		</c:forEach>
	</div>
	<div class="dialog">
		
	</div>
</body>
</html>






