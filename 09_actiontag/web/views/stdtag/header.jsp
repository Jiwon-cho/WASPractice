<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<style>
ul{


}
li{
display: inline-block;
margin-right:20px;
font-size:20px;
font-weight:bold;
}

</style>


</head>
<%
String name="자고싶다";
%>
<body>
	<h2> <%=request.getParameter("title") %></h2>
	<ul>
		<li>메인화면</li>
		<li>게시판</li>
		<li>갤러리</li>
		<li>자료실</li>
	
	</ul>
</body>
</html>