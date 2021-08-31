<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>글번호 :${requestScope.board.bno }</p>
		<p>제목 : ${requestScope.board.title }</p>
		<p>작성자 : ${requestScope.board.writer}</p>
		<p>조회수 : ${requestScope.board.bcount}, 좋아요 : ${requestScope.board.blike},싫어요 : ${requestScope.board.bhate}</p>
		
		<p>내용</p>
		<p>
			${requestScope.board.content }	
		</p>
		<p><button class="btnUpdate">수정</button>
		<button class="btnDelete">삭제</button>
		<button class="btnBack">뒤로가기</button></p>  
	</div>
</body>
</html>



