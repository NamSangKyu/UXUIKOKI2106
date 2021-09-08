<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.quest_container{
		display: flex;
		flex-direction: row;
		justify-content: space-around;
	}
	span{
		display:inline-block;
		/* border:1px solid black; */
		width:200px;
	}
	.content{
	text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="quest_container">
			<span>글번호 ${requestScope.dto.qno }</span>
			<span>문의 등록일 ${requestScope.dto.qdate }</span>
			<span>작성자 ${requestScope.dto.qwriter }</span>
			<span>
				<c:choose>
					<c:when test="${requestScope.dto.status=='0'}">
						읽지 않음
					</c:when>
					<c:when test="${requestScope.dto.status=='1'}">
						읽음
					</c:when>
					<c:when test="${requestScope.dto.status=='2'}">
						답변 보류
					</c:when>
					<c:otherwise>
						답변 완료
					</c:otherwise>
				</c:choose>
			</span>
		</div>
		<h3>문의 내용</h3>
		<div class="content">${requestScope.dto.qcontent } </div>
		<hr>
		<c:if test="${requestScope.dto.status =='3'}">
		<div class="answer_container">
			<h3>답변 내용</h3>
			<div>
				<span> 작성자 : ${requestScope.dto.awriter }</span>
				<span> 작성일 : ${requestScope.dto.adate }</span>
			</div>
			<div class="content">
				<form action="answerUpdate.do">
					<select name="status">
						<option value="3">답변완료</option>
						<option value="2">답변보류</option>
					</select>
					<textarea name="acontent">${requestScope.dto.acontent }</textarea>
					<button>답변 등록하기</button>
				</form>
			</div>
		</div>		
		</c:if>

	</div>
	
	
	
</body>
</html>