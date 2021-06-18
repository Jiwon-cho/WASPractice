<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>경품추첨결과</h3>
	<c:choose>
		<c:when test="${param.choice%5==0 }">
		<h3>아파트 분양권(강원도 산골 어딘가)</h3>
		</c:when>
		<c:when test="${param.choice%5==2 }">
		<h3>마카롱</h3>
		</c:when>
		<c:when test="${param.choice%5==4 }">
		<h3>1조</h3>
		</c:when>
		<c:otherwise>
		<h3>꽝 다음기회를....</h3>
		</c:otherwise>
		</c:choose>

</body>
</html>