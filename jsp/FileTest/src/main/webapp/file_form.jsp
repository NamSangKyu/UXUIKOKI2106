<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		var count = 3;
		$("#plus").click(function(){
			if(count==5)return;
			count++;
			$("#frm").append("<p><input type='file' name='"+count+"'></p>");
		});
		$("#minus").click(function(){
			if(count==1)return;
			count--;
			$("#frm").children("p").last().remove();
		});
	});
</script>
</head>
<body>
	<form action="upload.do" method="post" id="frm" enctype="multipart/form-data">
		<p><input type="text" name="writer" placeholder="작성자"> </p>
		<p><button>전송</button></p>
		<p>
			<input type="file" name="file1">
			<button type="button" id="plus">+</button>
			<button type="button" id="minus">-</button>
		</p>
		<p><input type="file" name="file2"></p>
		<p><input type="file" name="file3"></p>
	</form>
</body>
</html>





