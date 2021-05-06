<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
    
    </style>
</head>
<body>

    <%@include file="common/header.jsp"  %>
       <h1><%=checkTest %></h1>
    <section>
        <h2>게시판내용</h2>


    </section>
   <%@include file="common/footer.jsp" %>

</body>
</html>