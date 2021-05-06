<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("request","requestData");
		request.setAttribute("hobby",new String[]{"게임","코딩","축구","실뜨기"});
		session.setAttribute("session","sessionData");
		application.setAttribute("application","applicationData");
		out.print(session.getAttribute("userId"));
		out.print(application.getAttribute("email"));
		
		//페이지전환도 가능함.
 		request.getRequestDispatcher("/")
		.forward(request, response);
/* 		response.sendRedirect(request.getContextPath()); */
		
	%>
</body>
</html>






