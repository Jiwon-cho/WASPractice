<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 String userId=(String)request.getAttribute("userId");
 String check=(String)request.getAttribute("checkId");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인 창</title>
<style>
div#checkId-container{text-align:center;padding-top:50px;}
span#duplicated{color:red;font-weight:bold;}
</style>
</head>
<body>
<div id="checkId-container">
	<%if(check==null) {%>
			<span>[<%=userId %>]</span>는 사용가능합니다.	
			<br><br>
			<button type="button" onclick="fn_close();">닫기</button>
			<%}else{%>
			<span id="duplicated">[<%=userId %>]</span>는 사용중입니다.
			<br><br>
			<!-- 아이디 재입력창 구성 -->
			<form action="<%=request.getContextPath()%>/checkDuplicateId" method="post">
				<input type="text" name="userId" id="userId">
				<input type="submit" value="중복검사" >
			</form>
			<%} %>
	</div>
	
	<script>
	const fn_close=()=>{
		opener.document.getElementById("userId_").value='<%=userId%>';
		opener.document.getElementById("password_").focus();
		window.close();
	
	}
	</script>

</body>
</html>