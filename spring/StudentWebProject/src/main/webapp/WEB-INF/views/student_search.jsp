<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".search").click(function() {
			var d = $("form").serialize();
			$.ajax({
				url : "search.do",
				data : d,
				type:"get",
				dataType:"json",
				success:function(r){
					console.log(r);
					var tag = "";
					var arr = r.result;
					
					for(i=0;i<arr.length;i++){
						tag += "<tr>";
						tag += "<td>"+arr[i].sno+"</td>";
						tag += "<td>"+arr[i].name+"</td>";
						tag += "<td>"+arr[i].major+"</td>";
						tag += "<td>"+arr[i].score+"</td>";
						tag += "</tr>";
					}
					$(".result").html(tag);
				}
				
			});
		});
	});
</script>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	.form_container form{
	display: inline-block;
	}
	.form_container {
		padding:10px 0px;
		text-align: center;
	}
	.result{
		margin:0 auto;
	}
	td{
		padding:10px 10px;
		text-align: center;
	}
</style>
</head>
<body>
	<div class="form_container">
	<form>
		<select name="kind">
			<option value="sno">학번</option>
			<option value="name">이름</option>
		</select>
		<input type="text" name="search">
		<button type="button" class="search">검색</button>
		<button type="button" class="reset">리셋</button>
	</form>
	</div>
	<hr>
	<table class="result">
		<c:forEach var="s" items="${requestScope.list }">
			<tr>
				<td>${s.sno }</td>
				<td>${s.name}</td>
				<td>${s.major }</td>
				<td>${s.score }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>







