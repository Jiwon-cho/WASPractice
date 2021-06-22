<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그외 core 태그 알아보기</title>
</head>
<body>
	<h3>c:import이용하기</h3>
	<p>
		현 페이지에서 다른 페이지를 불러오는 것! --> 페이지를 불러와서 바로 출력하지 않음
	</p>
	<c:import var="h" url="http://google.com"/>
	
<%-- 	<c:out value="${h }" escapeXml="false"/> --%>
	
	<h3>c:url 이용하기</h3>
	<p>주소를 저장하는 태그 c:set과 동일한 기능을 함.</p>
	<c:set var="naver" value="https://search.naver.com/search.naver?query=유지훈"/>
	
	<c:url var="na" value="https://search.naver.com/search.naver">
		<c:param name="query" value="김가현"/>
		<c:param name="query" value="노상민"/>
	</c:url>
	
	
	<a href="${naver }">네이버 검색_set</a>
	<a href="${na }">네이버 검색_url</a>
	
	<h3>c:redirect이용하기</h3>
	<p>respnose.redirect 하고 동일한 기능을하는 태그</p>
	
<%-- 	<c:redirect url="http://www.iei.or.kr">
		<c:param name="test" value="test"/>
	</c:redirect> --%>
	<h3>c:catch 이용하기</h3>
	<p>try catch와 똑같음</p>
	
<%
String test=null;

%>	
<c:catch var="e">
	<%=test.charAt(0) %>
	</c:catch>
	${e }
	
	
</body>
</html>