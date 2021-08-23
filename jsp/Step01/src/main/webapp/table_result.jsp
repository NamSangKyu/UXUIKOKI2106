<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
	border-collapse: collapse;
	}
	td{
	border : 1px solid black;
	padding:20px;
	}
</style>
</head>
<body>
<%
	//데이터 준비
	int row = Integer.parseInt(request.getParameter("row"));
	int col= Integer.parseInt(request.getParameter("col"));
	int num = 1;
%>
	<table>
<%
	for(int i=0;i<row;i++){
		//tr 생성
	%>
		<tr>
	<%	
		for(int j=0;j<col;j++){
			//td  생성
			%>
				<td><%=num %></td>
			<%
			num++;
		}
		//tr 마감
	%>
		</tr>	
	<%
	}
%>
	</table>
</body>
</html>
