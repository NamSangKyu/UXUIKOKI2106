<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			var d = $("form").serialize();
			$.ajax({
				url : "insert.do",
				data : d,
				type: "get",
				dataType : "json",
				success : function(r) {
					console.log(r);
					var tag = "";
					var arr = r.data;
					for(i=0;i<arr.length;i++){
						tag += arr[i].PRODUCT_NO+ " " + arr[i].PRODUCT_NAME + " " +
						arr[i].PRICE + " " + arr[i].MAKER+ " " + arr[i].EA +"<br>";
					}
					$(".result").html(tag);
				},
				error : function(xhr,errorText,errThron) {
					console.log(xhr);
					alert(xhr.responseText);
				}
			});
			
		});
	});

</script>
<style type="text/css">
	.container{
		width:1200px;
		margin : 0 auto;;
	}
</style>
</head>
<body>
	<div class="container">
		<form>
			<input type="text" name="pno" placeholder="상품번호 입력"> <input
				type="text" name="pname" placeholder="상품명 입력"> <input
				type="text" name="maker" placeholder="제조사 입력"> <input
				type="text" name="price" placeholder="금액 입력"> <input
				type="text" name="ea" placeholder="재고 입력">
			<button type="button">등록</button>
		</form>
		<hr>
		<div class="result"></div>
	</div>
</body>
</html>



