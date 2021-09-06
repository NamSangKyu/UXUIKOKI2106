<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
	margin:0;
	padding:0;
	}
	th, td{
		padding:5px 10px;
		text-align: center;
	}
</style>
</head>
<body>
	<form action="insertProduct.do">
		<input type="text" name="pno" placeholder="제품번호">
		<input type="text" name="pname" placeholder="제품명">
		<input type="text" name="price" placeholder="금액">
		<input type="text" name="maker" placeholder="제조사">
		<button>추가</button>
	</form>
 <hr>
 <table>
 	<tr>
		<th>제품번호</th> 		
		<th>제품명</th> 		
		<th>금액</th> 		
		<th>제조사</th> 
		<th>비고</th>		
 	</tr>
 	<c:forEach var="obj" items="${requestScope.list }" >
 		<tr>
 			<td>${obj.pno }</td>
 			<td>${obj.pname }</td>
 			<td>${obj.price }</td>
 			<td>${obj.maker }</td>
 			<td><a href="deleteProduct.do?pno=${obj.pno }">삭제</a></td>
 		</tr>
 	</c:forEach>	
 </table>
</body>
</html>





