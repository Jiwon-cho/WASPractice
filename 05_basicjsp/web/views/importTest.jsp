<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List,java.util.ArrayList, java.util.Random" %> 
    
<%
	List<String> lsit=new ArrayList();	
	Random r=new Random();

%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=r.nextInt(100) %></h2>

</body>
</html>