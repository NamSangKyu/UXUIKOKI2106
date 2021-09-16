
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	var status = false;//아이디 중복확인한 결과를 저장할 전역변수
	$(function() {
		$(".btnIdCheck").click(function() {
			var d = "id="+$("input[name=id]").val();
			//alert(d);
			$.ajax({
				data:d,
				url : "idCheck.do",
				type:"post",
				dataType:"json",
				success:function(r){
					status = r.result;
					if(status=="true")
						$(".id_result").html("아이디가 중복되지 않았습니다.");
					else
						$(".id_result").html("아이디가 중복됩니다.");
				}
			});//ajax
		});//btnIdCheck
		$("form").submit(function(e) {
			if(status == "false"){
				alert("아이디 중복 확인을 하세요");
				e.preventDefault();	
			}
		});
	});//document
</script>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="memberRegister.do">
		<input type="text" name="id" placeholder="아이디를 입력하세요">
		<button class="btnIdCheck" type="button">아이디중복확인</button><br> 
		<span class="id_result"></span><br>
		<input type="text" name="pass" placeholder="암호를 입력하세요"><br> 
		<input type="text" name="name" placeholder="이름을 입력하세요"><br> 
		<input type="text" name="age" placeholder="나이를 입력하세요"><br> 
		<input type="radio" name="gender" value="0">남 
		<input type="radio" name="gender" value="1">여<br> 
		<button>가입하기</button>
	</form>
</body>
</html>