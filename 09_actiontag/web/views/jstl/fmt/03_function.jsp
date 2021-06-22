<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str" value="How Are You? i am fine"/>
	<p>str : <c:out value="${str }"/></p>
	<p>uppercase : <c:out value="${fn:toUpperCase(str) }"/></p>
	<p>replace : <c:out value="${fn:replace(str,'fine','tired') }"/></p>
	<p>contains : <c:out value="${fn:contains(str,'you')?'you 있다':'you 없다' }"/></p>
</body>
</html>









