<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>jquery ajax html파일 가져오기</h2>
<button id="btn">가져오기</button>
<div id="container"></div>
<script>
	$("#btn").click(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/htmlTest.do",
			type:"get",
			data:"html",
			success:data=>{
				console.log(data);
				$("#container").html(data);
			}
		})
	});

</script>
</body>
</html>