<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#container{
width:200px;
height:200px;
border: 1px solid black;
background-color:purple;

}

</style>
<%request.setCharacterEncoding("utf-8");%>
<%@include file="header.jsp" %> 
<jsp:include page="header.jsp">
	<jsp:param name="title" value="본문내용 출력중..."/>
</jsp:include>
<section>
<h2>본문 내용</h2>
<div id="container">
<h3><%=name %></h3>

</div>
</section>


</html>