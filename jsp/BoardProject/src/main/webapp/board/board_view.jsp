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
				dataType:"json",
				success:function(r){
					alert(r.msg);
					if(r.code == 400)
						location.href = "${pageContext.request.contextPath}/index.jsp";
					else 
						location.reload();
				}
			});
		});
		$(".hate").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : $(this).attr("href"),
				type:"get",
				dataType:"json",
				success:function(r){
					alert(r.msg);
					if(r.code == 400)
						location.href = "${pageContext.request.contextPath}/index.jsp";
					else 
						location.reload();
				}
			});
		});
		$(".btnBack").click(function () {
			history.back();
		});
		$("#btnComment").click(function(){
			var param = $("#comment_frm").serialize();
			$.ajax({
				url : "insertComment.do",
				data : param,
				type:"get",
				dataType:"json",
				success:function(r){
					//alert(r.code);
					console.log(r);
					var tag ="<table>";
					tag = "<tr><th>작성자</th><th>작성일</th><th>내용</th><th>좋아요</th><th>싫어요</th></tr>"
					for(i=0;i<r.list.length;i++){
						tag+="<tr>";
						tag += "<td>"+r.list[i].writer + "</td><td>" + r.list[i].date + "</td><td>" + r.list[i].content + "</td><td>" + r.list[i].clike + "</td><td>" + r.list[i].chate  +"</td>";
						tag+="</tr>";
					}
					tag +="</table>";
					$(".comment_list").html(tag);
				}
			});
			$("#comment_frm")[0].reset();//폼 초기화
		});
		//댓글 로드
		$.ajax({
			url : "selectComment.do",
			data : "bno=${requestScope.board.bno }",
			type:"get",
			dataType:"json",
			success:function(r){
				var tag ="<table>";
				tag = "<tr><th>작성자</th><th>작성일</th><th>내용</th><th>좋아요</th><th>싫어요</th></tr>"
				for(i=0;i<r.list.length;i++){
					tag+="<tr>";
					tag += "<td>"+r.list[i].writer + "</td><td>" + r.list[i].date + "</td><td>" + r.list[i].content + "</td><td>" + r.list[i].clike + "</td><td>" + r.list[i].chate  +"</td>";
					tag+="</tr>";
				}
				tag +="</table>";
				$(".comment_list").html(tag);
			}
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
			좋아요 : <a href="boardLike.do?bno=${requestScope.board.bno}" class="like">${requestScope.board.blike}</a>,싫어요 : <a href="boardHate.do?bno=${requestScope.board.bno}" class="hate">${requestScope.board.bhate}</a></p>
		
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
	<div class="comment_area">
		<c:if test="${sessionScope.obj != null }">
		<form id="comment_frm">
			<input type="hidden" name="bno" value="${requestScope.board.bno }">
			<textarea name="content" placeholder="댓글 내용을 입력하세요"></textarea>
			<button type="button" id="btnComment">입력</button>
		</form>
		</c:if>
		<hr>
		<!-- 댓글 출력 -->
		<div class="comment_list"></div>
	</div>
</body>
</html>



