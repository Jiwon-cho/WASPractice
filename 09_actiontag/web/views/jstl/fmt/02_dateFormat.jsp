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
	<c:set var="today" value="<%=new java.util.Date() %>"/>
	<c:out value="${today }"/>
	<h3>날짜를 간편하게 형식에 맞춰 출력해보자</h3>
	<p>
		fmt:formatData태그를 이용함-> 날짜, 시간에 대한 형식을 정할 수 있음
		type속성으로 출력할 내용을 정함.
		date(날짜), time(시간), both(날짜 시간 다)
	</p>
	<h4>시간 출력하기</h4>
	<p>기본시간: <fmt:formatDate value="${today }" type="time"/></p>
	<h4>날짜 출력하기</h4>
	<p>기본잘짜: <fmt:formatDate value="${today }" type="date"/></p>
	<h4>날짜/시간 모두 출력하기</h4>
	<p>모두 출력: <fmt:formatDate value="${today }" type="both"/></p>
	
	<h4>정해진 패턴대로 출력하기</h4>
	<h3>날짜 출력하기 -> dateStyle 속성 default, short,long, full</h3>
	<p>default:
		<fmt:formatDate value="${today }" type="date" dateStyle="default"/>
	</p>
	<p>short:
		<fmt:formatDate value="${today }" type="date" dateStyle="short"/>
	</p>
	<p>long:
		<fmt:formatDate value="${today }" type="date" dateStyle="long"/>
	</p>
	<p>full:
		<fmt:formatDate value="${today }" type="date" dateStyle="full"/>
	</p>
	<h3>정해진 형식대로 시간 출력하기 timeStyle short long medium full</h3>
		<p>short:
		<fmt:formatDate value="${today }" type="time" timeStyle="short"/>
	</p>
	<p>long:
		<fmt:formatDate value="${today }" type="time" timeStyle="long"/>
	</p>
	<p>medium:
		<fmt:formatDate value="${today }" type="time" timeStyle="medium"/>
	</p>
	<p>full:
		<fmt:formatDate value="${today }" type="time" timeStyle="full"/>
	</p>
	
	<p>combine:
		<fmt:formatDate value="${today }" type="both" dateStyle="long" timeStyle="full"/>
	</p>
	
	<h4>패턴으로 날짜를 표현</h4>	
	<p>
		SimpleDateFormat 에서 사용한 format으로 패턴을 지정함.
		y년, M 월, d 일,h 시, m 분, s 초, sss 밀리세컨초, E 요일
		pattern 속성에 조합해서 사용
	</p>
	<p><fmt:formatDate value="${today }" pattern="yy/MM/dd"/></p>
		<p><fmt:formatDate value="${today }" pattern="hh:mm:ss"/></p>
			<p><fmt:formatDate value="${today }" pattern="yy년 MM월 dd일 (E) hh:mm:ss"/></p>
	
	<h4>timeZone 설정하기</h4>
	<p>
		<fmt:timeZone value="GMT">
			<fmt:formatDate value="${today }" type="time" timeStyle="full"/>
		</fmt:timeZone>	
	</p>
	<p>
	<fmt:timeZone value="GMT+9">
			<fmt:formatDate value="${today }" type="time" timeStyle="full"/>
		</fmt:timeZone>	
	</p>
	
	<h4>로케일 변경하기</h4>
	<%-- <fmt:setLocale value="ja_Jp"/> --%>
	<fmt:setLocale value="en_US"/>
	<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>
	<fmt:formatNumber value="100000000" type="currency"/>	
</body>
</html>