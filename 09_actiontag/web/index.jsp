<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그</title>
</head>
<body>
	<h2>표준 액션 태그</h2>
	<p>
	jsp에서 기본적으로 제공하는 java태그 <br>
	jsp: 태그명 prefix(접두어)를 사용함
	
	</p>
	<a href="<%=request.getContextPath() %>/views/stdtag.jsp">stdtag</a>

</body>
</html>