<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.model.vo.Member" %>    
<%
   	//Member loginMember=(Member)request.getAttribute("loginMember");   
	Member loginMember=(Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloMVC</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1>Hello MVC</h1>
			<div class="login-container">
				<%if(loginMember==null) {%>
				<form id="loginFrm" action="<%=request.getContextPath() %>/login" method="post"
				onsubmit="return fn_invalidate();">
					<table>
						<tr>
							<td>
								<input type="text" name="userId" id="userId"
								placeholder="아이디">
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
							<input type="password" name="password" id="password"
							placeholder="비밀번호">
							</td>
							<td>
								<input type="submit" value="로그인">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="checkbox" name="saveId" id="saveId">
								<label for="saveId">아이디저장</label>
								<input type="button" value="회원가입">
							</td>
						</tr>
					</table>
				</form>
				<%} else{%>
				<table id="logged-in">
				<tr>
				<td colspan="2">
				<%=loginMember.getUserName() %>님, 환영합니다.
				</td>
				</tr>
				<tr>
				<td>
				<input type="button" value="내 정보보보기">
				</td>
				<td>
				<input type="button" value="로그아웃"
				onclick='fn_logout();'>
				</td>
				</table>
			
				<%} %>
			</div>
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="">Home</a></li>
					<li id="notice"><a href="">공지사항</a></li>
					<li id="board"><a href="">게시판</a></li>
				</ul>
			</nav>
		</header>
		
		<script>
			const fn_invalidate=()=>{
				const userId=$("#userId").val();
				const pw=$("#password").val();
				if(userId.trim().length<4){
					alert("아이디를 4글자이상 입력하세요")
					return false;
				}
				if(pw.trim().length==0){
					alert("패스워드를 입력하세요!")
					return false;
				}
				return true;
			}
			
			const fn_logout=()=>{
				location.replace("<%=request.getContextPath()%>/logout")
			}
		
		</script>
		
		
		
		
		
		
		
		
		