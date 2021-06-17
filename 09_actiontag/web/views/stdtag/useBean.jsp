<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.action.model.vo.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
	Person p1=(Person)request.getAttribute("p");
	
	%>
	<p><%=p1 %></p> --%>
	<h2>jsp:useBean태그를 이용하면??</h2>
	<jsp:useBean id="p2" class="com.action.model.vo.Person" scope="request"/>
	<!-- Person p2=new Person(); 이거랑 위랑 같음 -->
	<jsp:getProperty name="p2" property="name"/>
	<jsp:getProperty name="p2" property="age"/>
	<jsp:getProperty name="p2" property="addr"/>
	<br>
	<jsp:setProperty name="p2" property="name" value="호랑이"/>
	<jsp:setProperty name="p2" property="age" value="26"/>
	<jsp:setProperty name="p2" property="addr" value="미국"/>
	<br>
		<jsp:getProperty name="p2" property="name"/>
	<jsp:getProperty name="p2" property="age"/>
	<jsp:getProperty name="p2" property="addr"/>
	
	
	<h2>파라미터로 보낸 값을 useBean태그 용해서 저장하기</h2>
	<jsp:useBean id="paramP" class="com.action.model.vo.Person"/>
	<jsp:setProperty property="name"  name="paramP" param="name"/>
	<jsp:setProperty property="age"  name="paramP" param="age"/>
	<jsp:setProperty property="addr"  name="paramP" param="addr"/>
	<br>
	이름: <jsp:getProperty property="name"  name="paramP"/>			
	나이:<jsp:getProperty property="age"  name="paramP"/>
	주소: <jsp:getProperty property="addr"  name="paramP"/>
	
	<h3>jsp:forward 태그 이용</h3>
	<a href="<%=request.getContextPath() %>/views/stdtag/forward.jsp">전환하기</a>
</body>
</html>