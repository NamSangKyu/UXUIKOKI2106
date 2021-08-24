<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//개수 읽어옴
		int ea = Integer.parseInt(request.getParameter("ea"));
		HashSet<Integer> set = null;
		Random r = new Random();
		String result = "<table>";
		for(int i=0;i<ea;i++){
			//로또번호 생성
			set = new HashSet<Integer>();
			while(set.size()<6){
				set.add(r.nextInt(45)+1);
			}
			//태그로 변환 - 한세트 완성 
			result += "<tr>";
			Object[] arr = set.toArray();
			for(int j=0;j<arr.length;j++){
				result += "<td>"+arr[j]+"</td>";
			}
			result += "</tr>";
		}
		result += "</table>";
		request.setAttribute("lotto", result);	
		 //페이지 이동
		request.getRequestDispatcher("lotto_result.jsp").forward(request, response);
	%>
</body>
</html>






