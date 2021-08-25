<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$("button").click(function(){
			//폼 태그에 있는 input 태그에 입력한 내용을 전부 쿼리스트링으로 자동으로 생성
			var data = $("#frm").serialize();
			$.ajax({
				url:"member_select_grade_ajax.jsp",
				data : data,
				type:"get",
				success : function(result){
					result = result.trim();
					//받아온 데이터를 쪼개서 테이블 형태로 출력 split
					var tag = "<table>";
					var row = result.split("\n");
					for(i=0;i<row.length;i++){
						var tr = row[i].split(",");
						tag += "<tr>";
						console.log(tr);
						for(j=0;j<tr.length;j++){
							console.log(tr[j]);
							tag += "<td>"+tr[j]+"</td>";
						}
						tag += "</tr>";
					}
					tag += "</table>";
					$("#result").html(tag);					
				}	
			});
		})
	});
</script>
</head>
<body>
	<form id="frm">
		<select name="grade">
			<option value="Bronze">Bronze</option>
			<option value="Silver">Silver</option>
			<option value="Gold">Gold</option>
			<option value="DIAMOND">DIAMOND</option>
			<option value="VIP">VIP</option>
			<option value="VVIP">VVIP</option>
		</select>
		<button type="button">검색</button>
	</form>
	<div id="result"></div>
</body>
</html>





