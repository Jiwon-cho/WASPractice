<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='<%=request.getContextPath() %>/zz' method="get">
<input type="text" id="add1" name="address">
<input type="text" id="add2" name="address">
<input type="submit" value="s">
</form>
</body>
</html>