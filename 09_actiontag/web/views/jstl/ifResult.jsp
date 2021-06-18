<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if문에 대한 결과 출력</title>
</head>
<body>
	<c:if test="${param.su+param.su2>100 }">
		<h3>값이 크구나</h3>
	</c:if>
	<c:if test='${param.color=="red" }'>
		<h2 style="color:${param.color }">빨강색을 고르셨네요</h2>
	</c:if>
		<c:if test='${param.color eq "blue" }'>
		<h2 style="color:${param.color }">파랑색을 고르셨네요</h2>
	</c:if>
		<c:if test='${param.color eq "yellow" }'>
		<h2 style="color:${param.color }">노강색을 고르셨네요</h2>
	</c:if>


</body>
</html>







