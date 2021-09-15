<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resource/lib/jquery-3.6.0.min.js"></script>
<script>
	function writeResult(r){
		var tag = "";
		for(i=0;i<r.length;i++){
			tag += "<form>";
			tag += "<input type='text' name='id' value='"+r[i].id+"'>";
			tag += "<input type='text' name='passwd' value='"+r[i].pass+"'>";
			tag += "<input type='text' name='name' value='"+r[i].name+"'>";
			tag += "<input type='text' name='age' value='"+r[i].age+"'>";
			tag += "<input type='text' name='grade' value='"+r[i].grade+"'>";
			tag += "<button type='button' class='btnUpdate'>수정</button>";
			tag += "<button type='button' class='btnDelete'>삭제</button>";
			tag += "</form>";
		}
		$(".result").html(tag);
		updateEvent();
	} 
	function updateEvent(){
		$(".btnDelete").click(function() {
			//alert($(this).parent().find("input[name=id]").val());
			$.ajax({
				data:"id="+$(this).parent().find("input[name=id]").val(),
				url : "delete.do",
				dataType:"json",
				type:"get",
				success:function(r){
					writeResult(r);
				}
			});
		});
		$(".btnUpdate").click(function() {
			var d =	$(this).parent().serialize();
			$.ajax({
				data:d,
				url : "update.do",
				dataType:"json",
				type:"get",
				success:function(r){
					writeResult(r);
				}
			});
		});
	}
	$(function() {
		updateEvent();
		$(".btnRegister").click(function() {
			var d = $(this).parent().serialize();
			$.ajax({
				data : d,
				url : "insert.do",
				type:"post",
				dataType:"json",
				success:function(r){
					writeResult(r);
				}
			})
		});
		$(".search").keyup(function(){
			var d = "search="+$(this).val();
			$.ajax({
				data : d,
				url : "search.do",
				type:"get",
				dataType:"json",
				success:function(r){
					writeResult(r);
				}
			});
		});
	});
</script>
</head>
<body>
	${sessionScope.dto.id }님 로그인<br>
	<!-- 로그아웃 처리 -->
	<a href="logout.do">로그아웃</a>
	<!-- 회원정보 추가 -->
	<form>
		<input type="text" name="id" placeholder="아이디를 입력하세요">
		<input type="password" name="passwd" placeholder="암호를 입력하세요">
		<input type="text" name="name" placeholder="이름을 입력하세요">
		<input type="text" name="age" placeholder="나이를 입력하세요">
		<button type="button" class="btnRegister">등록</button>
	</form>
	<hr>
	<!-- 
		검색창
		검색어를 입력할때 마다 입력한 내용을 기준으로
		아이디, 이름, 등급에 해당내용이 포함되면 화면에 출력 
	-->
	검색 : <input type="text" class="search" placeholder="검색어 입력하세요">
	<hr>
	<div class="result">
	<!-- 전체 회원 목록을 출력 -->
	<c:forEach var="obj" items="${requestScope.list }">
		<form>
		<input type="text" name="id" value="${obj.id }">
		<input type="text" name="passwd" value="${obj.pass }">
		<input type="text" name="name" value="${obj.name }">
		<input type="text" name="age" value="${obj.age }">
		<input type="text" name="grade" value="${obj.grade }">
		<button type="button" class="btnUpdate">수정</button>
		<button type="button" class="btnDelete">삭제</button><!-- 삭제 처리 Ajax로 삭제 처리 -->
		</form>
		
	</c:forEach>
	</div>
</body>
</html>



