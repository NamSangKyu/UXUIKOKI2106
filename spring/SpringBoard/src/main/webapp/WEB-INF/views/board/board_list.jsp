<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
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
	});
</script>
<style type="text/css">
	table{
		border-collapse: collapse;
		margin:0 auto;
	}
	th, td{
		padding:5px 10px;
		text-align: center;
		font-size: 1.3rem;
	}
</style>
</head>
<body>
	<a href="memberUpdateView.do">${sessionScope.client.id }</a>님이 로그인하셨습니다.<br>
	<a href="logout.do">로그아웃</a>
	<hr>
	<table>
	<tr>
		<td colspan="7">
		언어선택 : <select name="target" id="target">
				<option value="ko" <c:if test="${sessionScope.target=='ko' }">selected</c:if>>한국어</option>
				<option value="en" <c:if test="${sessionScope.target=='en' }">selected</c:if>>영어</option>
				<option value="ja" <c:if test="${sessionScope.target=='ja' }">selected</c:if>>일본어</option>
				<option value="zh-CN" <c:if test="${sessionScope.target=='zh-CN' }">selected</c:if>>중국어</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
		<th>조회수</th>
		<th>좋아요</th>
		<th>싫어요</th>
	</tr>
	<c:forEach var="board" items="${requestScope.list }">
	<tr>
		<td>${board.bno }</td>
		<td><a href="boardView.do?bno=${board.bno }">${board.title }</a></td>
		<td>${board.writer }</td>
		<td>${board.bdate }</td>
		<td>${board.bcount }</td>
		<td>${board.blike }</td>
		<td>${board.bhate }</td>
	</tr>
	</c:forEach>
	<!-- 페이징 처리 -->
	<tr>
		<td colspan="7">
			<c:if test="${requestScope.pagging.priviousPageGroup }">
				<a href="boardList.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1 }"><<</a>			
			</c:if>			
			<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup}" end="${requestScope.pagging.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${i == requestScope.pagging.currentPageNo }">
						${i }
					</c:when>
					<c:otherwise>
						<a href="boardList.do?pageNo=${i} ">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${requestScope.pagging.nextPageGroup }">
				<a href="boardList.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1 }">>></a>			
			</c:if>			
		</td>
	</tr>
	<tr>
		<td colspan="7">
			<a href="boardWriteView.do">글쓰기</a>
		</td>
	</tr>
	</table>
	
</body>
</html>






