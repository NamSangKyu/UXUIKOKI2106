<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin:0;
		padding : 0;
		font-size: 18px;
	}
	section{
		width:800px;
		position:relative;
		margin:0 auto;
		text-align: center;
	}
	article{
		width:400px;
		padding : 10px 60px;
		box-sizing: border-box;
		float:left;
	}
	select{
		padding:15px 30px;
	}
	article:first-child{
		border-right: 2px solid #a8a8a8;
	}
	h1,h2{
		font-size: 24px;
		padding:20px 0px;
		text-align: center;
	}
	textarea {
		width:100%;
		height:500px;
		padding:10px;
		box-sizing:border-box;
		resize: none;
	}
	#btn_translate{
		width: 50px;
		height: 50px;
		background-color: black;
		font-weight: bold;
		color:white;
		border-radius: 50px;
		position: absolute;
		left: 375px;
		top: 300px;
		outline: none;
		border:none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn_translate").click(function() {
			var d = "";
			d += "target="+$("#target").val();
			d += "&source="+$("#source").val();
			d += "&text="+$("#text").val();
			$.ajax({
				data : d,
				url:"translate.do",
				type:"get",
				success:function(d){
					$("#result").val(d);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>파파고 번역 페이지</h1>
	<section>
		<article>
			<select name="source" id="source">
				<option value="ko">한국어</option>
				<option value="en">영어</option>
				<option value="de">독일어</option>
				<option value="ja">일본어</option>
				<option value="zh-CN">중국어</option>
			</select>
			<h2>번역할 내용</h2>
			<textarea name="text" id="text"></textarea>
		</article>
		<article>
			<select name="target" id="target">
				<option value="ko">한국어</option>
				<option value="en">영어</option>
				<option value="de">독일어</option>
				<option value="ja">일본어</option>
				<option value="zh-CN">중국어</option>
			</select>
			<h2>번역된 내용</h2>
			<textarea name="result" id="result"></textarea>
		</article>
		<button id="btn_translate">>></button>
	</section>
</body>
</html>






