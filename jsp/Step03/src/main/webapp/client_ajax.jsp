<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax client</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			var url = "ajax_test.jsp";
			$.ajax({
				url : url,
				//data:data,
				type:"get",
				//dataType : "json",
				success:function (result){
					$("#result").html(result);
				}
			});
		});
	});
</script>
</head>
<body>
	<button id="btn">ajax 요청</button>
	<div id="result"></div>
</body>
</html>

