<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표준 액션 태그 이용하기</title>
</head>
<body>
<h2>jsp: include 활용</h2>
<p>
	외부의 다른 페이지를 현재페이지로 불러오는 태그
	&lt;jsp:include page="불러올 페이지의 주소" &gt;
	* &lt; %@ include file="" &gt;태그와 유사함
</p>
<a href="stdtag/include.jsp">include</a>
<h2>jsp:useBean태그</h2>
<p>
자바에서 사용하는 클래스를 생성해서 페이지에서 이용할 때 사용
vo 객체 이용

</p>
<a href="<%=request.getContextPath() %>/useBeanTest">useBean이용하기</a>
<form action="<%=request.getContextPath() %>/useBeanTest">
	<input type="text" name="name"/>
	<input type="text" name="age"/>
	<input type="text" name="addr"/>
	<input type="submit" value="저장"/>



</form>

</body>
</html>