<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl를 사용하기 위해서는 사용하는 페이지에서 지시문으로 태그를 선언해야함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>set/out 태그</h3>
	<p>c:set->변수를 선언하는 태그</p>
	<ul>c:set속성
		<li>var : 변수명</li>
		<li>value: 변수에 들어가는 값</li>
		<li>scope: 변수가 선언되는 내장 객체 위치 *생략하면 page에 저장</li>
	</ul>

<p>c:out -> 값을 페이지에 출력해주는 태그</p>
<ul> c:out 속성
<li>value: 출력할 값(리터럴,EL 표현식, &lt;%= &gt;)</li>
<li>default: 변수 가져왔을 때 없으면 출력되는 값 지정/ 있으면 있는 값 출력</li>
<li>escapeXml: 태그 형식으로 value를 작성했을 때 태그로 해석할지, 문자로 해석할지 정하는 속성(true,false)</li>
</ul>
<%
request.setAttribute("age",19);
String hobby="게임";
%>

<h3>페이지내 변수선언하기</h3>
<p>리터럴로 변수를 선언함.</p>
<c:set var="name" value="조지원"/>
<p>EL표현식으로 선언하기</p>
<c:set var="num" value="${age }"/>
<c:set var="path" value="${pageContext.request.contextPath }"/>

<h3>저장된 변수 출력하기</h3>
<c:out value="${name }"/>
<c:out value="돼지"/>
<c:out value="<%=hobby %>"/>
<h3>범위를 지정하여 저장하기</h3>
<c:set var="name" value="유지훈" scope="request"/>
<c:out value="${name }"/>
<c:out value="${requestScope.name }"/>

<h3>값 출력시 기본값 등록하기</h3>
<c:out value="${age }" default="10"/>
<c:out value="${age1 }" default="10"/>


<h3>c:out value 에 태그가 들어가면??</h3>
<c:out value="<h3>이거 h3태그야</h3>"/>
<c:out value="<h3>이거 h3태그야</h3>" escapeXml="false"/>
<!--false로 하면 태그로 읽음  -->
<c:out value="<h3>이거 h3태그야</h3>" escapeXml="true"/>

<%
request.setAttribute("script", "<script>alert('하하핳');</script>");
%>

<%-- ${script }; --%>
<c:out value="${script }"/>

	<h3><c:out value="${age }"/></h3>
	
	<input type="text" value="<c:out value='${age }'/>">

</body>
</html>