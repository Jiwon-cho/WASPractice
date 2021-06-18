<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>cookie값 가져오기</h3>
<h4>${cookie }</h4>
<h4>${cookie.c }</h4>
<h4>${cookie.c.name }</h4>
<h4>${cookie.c.value }</h4>

<h3>requestHeader에 있는 정보 가져오기</h3>
<h4>${header["User-Agent"] }</h4>
<h4>${header["Referer"] }</h4>
<script>
	setTimeout(()=>{
		location.href='${header["referer"]}';
	},1000);
</script>

</body>
</html>