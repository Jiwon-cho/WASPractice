<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 	String msg=(String)request.getAttribute("msg");
	String loc=(String)request.getAttribute("loc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알람 메세지</title>
</head>
<body>
<script>
	alert('<%=msg%>');
	location.replace('<%=request.getContextPath()%><%=loc%>');
	/* request 준곳은 메인페이지/ 거기의 콘텍스트 페스->메인 +/-> 메인 */
</script>

</body>
</html>