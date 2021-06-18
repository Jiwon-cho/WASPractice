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
java.util.List<String> names=java.util.List.of("유병승","유지훈","유혜신","유인범","유동현");
request.setAttribute("names",names);
%>
<h3>EL기본 출력하기</h3>
<P>EL로 작성해서 출력하는 데이터는 반드시 내장객체에 있는 값이어야 한다.</P>
<h3>${name1 } ${age }</h3>
<h3>객체 접근: ${p }</h3>
<ul>객체의 각 맴버변수 접근하기
<li><%-- ${p.getName() } --%>${p.name }</li>
<li>${p.age }</li>
<li>${p.addr }</li>
</ul>
<%-- <h3>기본 객체를 생성 할 수 있나?</h3>
<p>${new java.util.Date() }</p> 
  이렇게는 못함--%>
<h3>collection 객체 접근하기</h3>
<ul>
<li>list크기: ${names.size() }</li>
<li>list값: ${names.get(0).length() }</li>
</ul>
<%
request.setAttribute("su",20);
request.setAttribute("su1","30");
//문자로 해도 더하기 됨
%>
<h2>EL연산 처리하기</h2>
<h4>산술연산 처리</h4>
<p>su+su1: ${su+su1 }</p>
<p>su-su1: ${su-su1 }</p>
<p>su*77: ${su*77 }</p>
<p>${su+su1*77*730 }</p>
<p>su/3 : ${su/3 } ${su div 3 }</p>
<p>su%3: ${su%3 }</p>
<p>su+20  * 20 : ${su+20*20 } ${(su+20)*20 }</p>

<h3>비교연산처리</h3>
<p>su&lt;su1: ${su<su1 } ${su lt su1 }</p>
<p>su&gt;su1: ${su>su1 } ${su gt su1 }</p>	
<p>su&lt;=su1: ${su<=su1 } ${su le su1 }</p>
<p>su&gt;=su1: ${su>=su1 } ${su ge su1 }</p>	
<p>"유병승"==names.get(0): ${"유병승"==names.get(0) } ${"유병승" eq names.get(0) }</p>
<p>"유병승"!=names.get(1): ${"유병승"!=names.get(1) } ${"유병승" ne names.get(1) }</p>
<p>names.get(1).contains("병") : ${names.get(1).contains("병") }</p>
	<p>리스트가 비여있는지 확인 : ${names.isEmpty() } ${empty names }</p>
	<p>리스트가 비여있지 않은지 : ${not empty names }</p>
	<h3>논리연산</h3>
	<p>${not empty names && names.get(0) eq "유병승"}</p>
	<p>${not empty names and names.get(0) eq "유지훈"}</p>
	<p>${not empty names || names.get(0) eq "유지훈"}</p>
	<p>${not empty names or names.get(0) eq "유지훈"}</p>
	
	<h3>삼항연산자</h3>
	<p>${"돼지" eq "돼지"?"돼지":"안돼지" }</p>
	
	<select name="test">
		<option value="처녀귀신">처녀귀신</option>
		<option value="달걀귀신">달걀귀신</option>
		<option value="망태할아버지">망태할아버지</option>
		<option value="귀신시러" ${names.get(0) eq "유병승"?"selected":"" }>귀신시러</option>
	
	</select>
	
	<h4>서블릿에서 저장한 내용을 EL로 출력하기</h4>
	<a href="<%=request.getContextPath() %>/basicEl">서블릿에 저장</a>
	<a href="${pageContext.request.contextPath }/basicEl">서블릿에서 저장</a>
	
	<h4>파라미터로 보낸 데이터 EL로 출력하기</h4>
	<form action="${pageContext.request.contextPath }/basicEl">
	이름<input type="text" name="name"><br>
	나이<input type="text" name="age"><br>
	취미<br>
	<input type="checkbox" name="hobby" value="게임">게임
		<input type="checkbox" name="hobby" value="운동">운동
			<input type="checkbox" name="hobby" value="코딩">코딩
				<input type="checkbox" name="hobby" value="걷기">걷기
				<input type="submit" value="전송"/>
	<br>
	</form>
	
	<h4>추가 객체이용하기</h4>
	<a href="${pageContext.request.contextPath }/extraData">추가객체이용</a>
	
</body>
</html>