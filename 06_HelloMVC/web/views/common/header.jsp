<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.model.vo.Member" %>    
<%
   	//Member loginMember=(Member)request.getAttribute("loginMember");   
	Member loginMember=(Member)session.getAttribute("loginMember");

	//Cookie에 있는 값 가져오기
	Cookie []c=request.getCookies();
	String saveId=null;
	if(c!=null){
		for(Cookie k:c){
			if(k.getName().equals("saveId")){
				saveId=k.getValue();
				break;
			}
		}
	}
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
								placeholder="아이디" value="<%=saveId==null?"":saveId%>">
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
								<input type="checkbox" name="saveId" id="saveId"
							<%=saveId!=null?"checked":"" %>>
								<label for="saveId">아이디저장</label>
								<input type="button" value="회원가입"
								onclick="fn_register();">
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
				<input type="button" value="내 정보보보기" onclick="location.assign('<%=request.getContextPath()%>/memberView.do?userId=<%=loginMember.getUserId()%>')">
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
					<li id="notice"><a href="<%=request.getContextPath()%>/notice/noticeList">공지사항</a></li>
					<li id="board"><a href="<%=request.getContextPath()%>/board/boardList">게시판</a></li>
				<%if(loginMember!=null&&loginMember.getUserId().equals("admin")){ %>
					<li id="memberManage"><a href="<%=request.getContextPath()%>/admin/memberList"> 회원관리</a></li>
				<%}%>
				
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
			
			const fn_register=()=>{
				location.replace("<%=request.getContextPath()%>/register")
			}
			
		
		
		</script>
		
		
		
		
		
		
		
		
		