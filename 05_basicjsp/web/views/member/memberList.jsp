<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.model.vo.Member,java.util.List" %>    
<%
	List<Member> members=(List<Member>)request.getAttribute("members");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 조회결과</h1>
	<table>
		<tr>
			<th>회원아이디</th>
			<th>회원비밀번호</th>
			<th>회원이름</th>
			<th>회원성별</th>
			<th>회원나이</th>
			<th>회원이메일</th>
		</tr>
		<%if(members.isEmpty()) {%>
			<tr>
				<td colspan="6">조회된 회원이 없습니다.</td>
			</tr>
		<%} else{
				for(Member m : members){%>
				<tr>
					<td><%=m.getMemberId()%></td>
					<td><%=m.getMemberPwd() %></td>
					<td><%=m.getMemberName() %></td>
					<td><%=m.getGender() %></td>
					<td><%=m.getAge() %></td>
					<td><%=m.getEmail() %></td>
				</tr>
			<%} 
		}%>
	</table>
</body>
</html>