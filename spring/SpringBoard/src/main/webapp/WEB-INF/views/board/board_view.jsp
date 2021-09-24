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
		$("#target").change(function() {
			$.ajax({
				url : "language.do",
				data : "target="+$("#target").val(),
				type:"get",
				success : function (r) {
					location.reload();
				}
			});
		});
		$(".like").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : $(this).attr("href"),
				type: "get",
				dataType:"json",
				success:function(r){
					alert(r.msg);
					if(r.code == 400)
						location.href = "/";
					else
						location.reload();
				}
			});
		});
		$(".hate").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : $(this).attr("href"),
				type: "get",
				dataType:"json",
				success:function(r){
					alert(r.msg);
					if(r.code == 400)
						location.href = "/";
					else
						location.reload();
				}
			});
		});
	});
</script>
</head>
<body>
	언어선택 : <select name="target" id="target">
				<option value="ko" <c:if test="${sessionScope.target=='ko' }">selected</c:if>>한국어</option>
				<option value="en" <c:if test="${sessionScope.target=='en' }">selected</c:if>>영어</option>
				<option value="ja" <c:if test="${sessionScope.target=='ja' }">selected</c:if>>일본어</option>
				<option value="zh-CN" <c:if test="${sessionScope.target=='zh-CN' }">selected</c:if>>중국어</option>
			</select><br>
	제목 : ${requestScope.board.title }<br>
	작성자 : ${requestScope.board.writer}, 작성일 : ${requestScope.board.bdate}<br>
	조회수 : ${requestScope.board.bcount}, 
	좋아요 : <a href="boardLike.do?bno=${requestScope.board.bno}" class="like">${requestScope.board.blike}</a>,
	싫어요 : : <a href="boardHate.do?bno=${requestScope.board.bno}" class="hate">${requestScope.board.bhate}</a>
	<br>
	내용<br> ${requestScope.board.content}
	<hr>
	첨부파일 목록<br>
	<!-- 파일 링크 출력 -->
	<c:forEach var="f" items="${requestScope.flist }">
		첨부파일 : <a href="fileDownload.do?fno=${f.fno }">${f.originFileName }</a><br>
	</c:forEach>
	<hr>
	<button type="button" class=".btnBack">뒤로가기</button>
	<c:if test="${requestScope.board.writer == sessionScope.client.id }">
		<button type="button" class="btnUpdate">수정</button>
		<button type="button" class="btnDelete">삭제</button>
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
</body>
</html>








