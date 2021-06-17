<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.action.model.vo.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL표현식 활용하기</title>
</head>
<body>
<%
	String name="빌딩";
int age=24;
Person p=new Person("과로사",28,"분당");
request.setAttribute("name1",name);
session.setAttribute("age",age);
application.setAttribute("p",p);

%>
<h3>EL기본 출력하기</h3>
<P>EL로 작성해서 출력하는 데이터는 반드시 내장객체에 있는 값이어야 한다.</P>
<h3>${name1 } ${age }</h3>
<h3>객체 접근: ${p }</h3>
</body>
</html>