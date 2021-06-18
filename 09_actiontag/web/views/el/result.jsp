<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿에서 보낸 값 출력하기</title>
</head>
<body>
	<h4>사람</h4>
	<p>이름: ${p.name }</p>
	<p>이름: ${p.age }</p>
	<p>이름: ${p.addr }</p>

	<h4>리스트 출력</h4>
	<h${list.get(0) }>이건h1</h${list.get(0) }>
	<h${list.get(1) }>이건h2</h${list.get(1) }>
	<h${list.get(2) }>이건h3</h${list.get(2) }>
	<h${list.get(3) }>이건h4</h${list.get(3) }>
	
	<%-- <c:forEach var="i" items="${list }">
		<h${i }>h${i }</h>h${i }>
	</c:forEach> --%>
	
	<p>세션: ${today }</p>
	<p>세션의 list 출력: ${sessionScope.list }</p>
	<p>context: ${userId }</p>
	<p>cotnext의 p출력 : ${applicationScope.p }</p>
	
	<h3>파라미터 값 받기</h3>
	<p>파라미터 name: ${param.name }</p>
	<p>파라미터 name: ${param.age }</p>
	<p>파라미터 name: ${paramValues.hobby[0] }</p>
</body>
</html>