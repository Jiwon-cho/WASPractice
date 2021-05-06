<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String checkTest="이거 불러올 수 있나?";

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    ul>li{
        display: inline-block;
        margin-right:30px;
        font-size: 30px;
        font-weight:bolder;
    }
    li>a{
        text-decoration:none;
        color:magenta;
    }
	table{
		width:500px;
		heigth:400px;
		border:1px solid lime;
	}
	table td{
		border:3px dotted blue;
	}


</style>
</head>
<body>
    <header>
		<ul>
            <li><a href="main.jsp">메인화면</a></li>
            <li><a href="">갤러리</a></li>
            <li><a href="board.jsp">게시판</a></li>
            <li><a href="">자료실</a></li>
		</ul>
	</header>
