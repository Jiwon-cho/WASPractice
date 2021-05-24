<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
border:1px red solid;
}
</style>
</head>
<body>
<table>
	<tr>
	<th>나이</th>
	<th>이름</th>
	<th>성별</th>
	</tr>
	<%for(int i=0;i<10;i++){ %>
	<tr>
	<td>19</td>
	<td>조지원</td>
	<td>남</td>
	</tr>
	<%} %>
</table>


</body>
</html>