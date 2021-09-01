<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".like").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : $(this).attr("href"),
				type:"get",
				success:function(r){
					alert(r);
				}
			});
		});
		
	});
</script>
</head>
<body>
	<div>
		<p>글번호 :${requestScope.board.bno }</p>
		<p>제목 : ${requestScope.board.title }</p>
		<p>작성자 : ${requestScope.board.writer}</p>
		<p>조회수 : ${requestScope.board.bcount}, 
		좋아요 : <a href="boardLike.do?bno=${requestScope.board.bno}" class="like">${requestScope.board.blike}</a>,싫어요 : ${requestScope.board.bhate}</p>
		
		<p>내용</p>
		<p>
			${requestScope.board.content }	
		</p>
		<p>
		<!-- 해당 게시글 작성자와 현재 로그인한 사용자가 같을떄만 수정 삭제 버튼이 출력 되게끔 처리 jstl -> if-->
		<c:if test="${requestScope.board.writer == sessionScope.obj.id }">
			<button class="btnUpdate">수정</button>
			<button class="btnDelete">삭제</button>
			<!-- jquery나 js이용해서 해당 버튼 클릭 했을때 삭제 및 수정하는 기능을 수행
				삭제 수행 -> boardDelete.do?bno=?
				location.href 
			 -->
			 <script type="text/javascript">
			 		var btnDelete = document.querySelector(".btnDelete");
			 		btnDelete.onclick = function(){
			 			location.href = "boardDelete.do?bno=${requestScope.board.bno}";
			 		}
			 		var btnUpdate= document.querySelector(".btnUpdate");
			 		btnUpdate.onclick = function(){
			 			location.href = "boardUpdateView.do?bno=${requestScope.board.bno}";
			 		}
			 </script>
		</c:if>
		<button class="btnBack">뒤로가기</button></p>  
	</div>
</body>
</html>



