<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.action.model.vo.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문 활용하기</title>
</head>
<body>
	<h3>반복문 사용하기 -> c:forEach태그를 사용</h3>
	<p>반복문 두가지로 사용이 가능함</p>
	<p>1. 기본 for문으로 이용하기</p>
	<p>2. forEach무으로 사용(배열, collection값)</p>
	<ul>
		<li>begin: 초기값, 시작값</li>
		<li>end: 마지막 값</li>
		<li>step: 증감값</li>
	<li>var: 배열,collection 단일 값을 저장하는 변수</li>
	<li>items: 배열, collection을 대입하는 속성</li>
	<li>varStatus: 반복문에 대한 정보를 저장 하는 속성</li>
	</ul>
		
	<h3>기본 반복문 활용하기</h3>
	<h4>1~10까지 출력하기</h4>
	<c:forEach var="i" begin="1" end="10" step="1">
	<h4><c:out value="${i }"/> 이거 출력</h4>
	</c:forEach>
	<c:forEach var="i" begin="1" end="6">
	<h${i }>h${i }</h${i }>
	</c:forEach>
	
	<h3>배열이나 collection을 이용한 반복문</h3>
	<%
	List<Person> list=List.of(new Person("유병승",19,"시흥시"),
	new Person("돼지",29,"돼지우리"),
	new Person("뚱돼지",20,"축사"),
	new Person("댕댕이",10,"우리집"));
	request.setAttribute("list",list);
	
	%>
<c:if test="${not empty list }"	>
	<table border="1">
	<tr>
	<th>이름</th>
	<th>나이</th>
	<th>주소</th>
	</tr>
	<c:forEach var="p" items="${list }">
	<tr>
	<td><c:out value="${p.name }"/></td>
	<td><c:out value="${p.age }"/></td>
	<td><c:out value="${p.addr }"/></td>
	
	
	</tr>
	
	 </c:forEach>
</table>
</c:if>

<c:forEach var="p" items="${list }" varStatus="vs">
	${vs.index } ${vs.count } ${vs.first } ${vs.last }
	<br>
</c:forEach>
	<table>
	<c:forEach var="p" items="${list }" varStatus="vs">
		<c:if test="${vs.first }">
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
			</tr>
		</c:if>
		<tr>
			<td><c:out value="${p.name }"/></td>
			<td><c:out value="${p.age }"/></td>
			<td><c:out value="${p.addr }"/></td>
		</tr>
		<c:if test="${vs.last }">
			<tr>
				<td>총 인원</td>
				<td style="text-align:center" colspan="2">${vs.count }</td>
			</tr> 
		</c:if>
	</c:forEach>
	</table>
</body>
</html>