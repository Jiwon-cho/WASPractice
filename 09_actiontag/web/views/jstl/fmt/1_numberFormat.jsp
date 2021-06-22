<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기본숫자 표현하기</h1>
	<c:set var="numtest" value="1234501987"/>
	<c:set var="numtest1" value="19873000"/>
	<c:set var="numtest2" value="1"/>
	<c:set var="numtest3" value="1234.567"/>
	<h3>기본숫자 출력: ${numtest }</h3>
	<h3>기본숫자 출력: <c:out value="${numtest }"/></h3>
	<h3>기본fmt출력: <fmt:formatNumber value="${numtest }"/></h3>
		<h3>기본fmt출력: <fmt:formatNumber value="10000"/>원</h3>
	<h2>groupingUsed: 숫자를 3개로 구분하여 쉼표처리</h2>
	<h3>true: <fmt:formatNumber value="${numtest1 }" groupingUsed="true"/></h3>
	<h3>false: <fmt:formatNumber value="${numtest1 }" groupingUsed="false"/></h3>
	
	<h2>화페단위를 출력</h2>
	<p>type속성을 이용함-> currency</p>
	<h3><fmt:formatNumber value="${numtest1 }" type="currency"/></h3>
	<h3>${pageContext.request.locale }</h3>
	<h3><fmt:formatNumber value="${numtest1 }" type="currency" currencySymbol="^BS^"/></h3>

	<h2>퍼센트표시하기</h2>
	<p>
	type="percent", value="0~1값" 1:100%
	</p>
	<h3><fmt:formatNumber type="percent" value="${numtest2 }"/></h3>
	<h3><fmt:formatNumber type="percent" value="0.5"/></h3>
	<h3><fmt:formatNumber type="percent" value="0.05"/></h3>
		<h3><fmt:formatNumber type="percent" value="0.005"/></h3>
		<!--0근치는 0으로 봄 -->
	
	<h2>패턴으로 숫자 출력하기</h2>	
	<p>
	 	자리수를 표현하는 패턴
	 	#: 자리에 숫자가 있으면 표현을 하고 없으면 생략(공백)
	 	0: 자리에 숫자가 있으면 표현을 하고 없으면 0으로 표시함
	 </p>
	 <h3><fmt:formatNumber value="${numtest3 }"/></h3>
	 <h3><fmt:formatNumber value="${numtest3 }" pattern="000,000.000"/></h3>
	  <h3><fmt:formatNumber value="${numtest3 }" pattern="###,###.###"/></h3>
	  <h3><fmt:formatNumber value="${numtest3 }" pattern="###,###"/></h3> <!--반올림함 1234.567->1235  -->
  <h3><fmt:formatNumber value="${numtest3 }" pattern="###,###.00000"/></h3>
  
  <h2>소수점 제한두기</h2>
  <p>
  	minFractionDigits: 최소소수점 자리
  	maxFractionDigits: 최대 소수점 자리
  	</p>
  <h3><fmt:formatNumber value="123.12" minFractionDigits="5" pattern="###,###.##"/></h3> 
<h3><fmt:formatNumber value="123.141523125123" maxFractionDigits="5" pattern="###,###.##"/></h3> 

<h2>정수자리수 제한두기</h2>
<p>
 	minIntegerDigits: 최소 정수 자리수
 	maxInteerDigits: 최대 정수 자리수
 	</p>
 <h3><fmt:formatNumber value="12.14" minIntegerDigits="3"/></h3>
 <h3><fmt:formatNumber value="5212.14" maxIntegerDigits="3"/></h3>
</body>
</html>