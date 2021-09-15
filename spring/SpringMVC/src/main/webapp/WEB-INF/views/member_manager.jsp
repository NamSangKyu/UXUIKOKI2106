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
	$(function() {
		$(".btnDelete").click(function() {
			//alert($(this).parent().find("input[name=id]").val());
			$.ajax({
				data:"id="+$(this).parent().find("input[name=id]").val(),
				url : "delete.do",
				dataType:"json",
				type:"get",
				success:function(r){
					var tag = "";
					for(i=0;i<r.length;i++){
						tag += "<form>";
						tag += "<input type='text' name='id' value='"+r[i].id+"'>";
						tag += "<input type='text' name='passwd' value='"+r[i].passwd+"'>";
						tag += "<input type='text' name='name' value='"+r[i].name+"'>";
						tag += "<input type='text' name='age' value='"+r[i].age+"'>";
						tag += "<input type='text' name='grade' value='"+r[i].grade+"'>";
						tag += "<button type='button' class='btnDelete'>삭제</button>";
						tag += "</form>";
					}
					$(".result").html(tag);
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
		<a href="#">수정</a>
		<button type="button" class="btnDelete">삭제</button><!-- 삭제 처리 Ajax로 삭제 처리 -->
		</form>
		
	</c:forEach>
	</div>
</body>
</html>



