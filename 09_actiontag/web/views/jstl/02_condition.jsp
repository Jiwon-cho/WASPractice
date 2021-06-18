<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:조건문</title>
</head>
<body>
<h2>c:if문 활용 하기</h2>
<p>자바의 if문을 태그로 변경한것</p>
<p>&lt;c:if test="비교연산->EL활용"&gt; 로직 &lt;/c:if&gt;</p>
<ul>
		<li>test : true, false값이 나오는 연산, 변수를 대입</li>
		<li>var : test의 결과를 저장하는 변수</li>
	</ul>
	<c:set var="su" value="20"/>
	<c:set var="su2" value="30"/>
	
	<c:if test="${su == 20 }" var="result">
		<h3>${su }는 ${su2 }랑 같다</h3>
	</c:if>
	
	<c:out value="${result }"/>
	
	
	<form action="ifResult.jsp">
		<input type="number" name="su">
		<input type="number" name="su2">
		<select name="color">
			<option value="red">빨강</option>
			<option value="blue">파랑</option>
			<option value="yellow">노랑</option>			
		</select>
		<input type="submit" value="전송"/>
	</form>
	
	<h3>c:choose</h3>
	<p>java의 switch하고 비슷함</p>
	<p>
	c:choose
		c:when test="" 로직 /c:when
		c:when test="" 로직 /c:when
		c:when test="" 로직 /c:when
		c:when test="" 로직 /c:when
		c:otherwise 출력내용
	/c:choose
	</p>
	<h1>경품 뽑기</h1>
	<form action="chooseTest.jsp">
		숫자를 입력<input type="number" name="choice">
		<input type="submit" value="제출">
	
	
	</form>
	
	
	
</body>
</html>