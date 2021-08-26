<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button.obj").click(function() {
			$.ajax({
				url : "make_json.jsp",
				type:"get",
				dataType:"json",
				success : function(r) {
					console.log(r);
					var str = r.DD + " " + r.A + " " + r.C + " " + r.TEST; 
					$(".result1").html(str);
				}
			})
		});
		$("button.array").click(function() {
			$.ajax({
				url : "make_json_array.jsp",
				type:"get",
				dataType:"json",
				success : function(r) {
					console.log(r);
					var tag = "";
					for(i=0;i<r.length;i++){
						if(typeof r[i]  == "object"){
							tag += r[i].DD + " " + r[i].A + " " + r[i].C + " " + r[i].TEST; 
						}else{
							tag += r[i] + " ";						
						}
						console.log(typeof r[i]);
					}
					$(".result1").html(tag);
				}
			})
		});
	});
</script>
</head>
<body>
	<button class="obj">ajax json object call</button>
	<button class="array">ajax json object Array call</button>
	<hr>
	<div class="result1"></div>
	
</body>
</html>