<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.member.model.vo.Member" %>	
<%
	List<Member> list=(List<Member>)request.getAttribute("list");
	String searchType=request.getParameter("searchType");
	String searchKeyword=request.getParameter("searchKeyword");
%>	
	
	
<%@ include file="/views/common/header.jsp"%>
<style type="text/css">
section#memberList-container {
	text-align: center;
}

section#memberList-container table#tbl-member {
	width: 100%;
	border: 1px solid gray;
	border-collapse: collapse;
}

section#memberList-container table#tbl-member th, table#tbl-member td {
	border: 1px solid gray;
	padding: 10px;
}
/* 검색창에 대한 스타일 */
    div#search-container {margin:0 0 10px 0; padding:3px; 
    background-color: rgba(0, 188, 212, 0.3);}
    div#search-userId{display:inline-block;}
    div#search-userName{display:none;}
    div#search-gender{display:none;}
    div#numPerpage-container{float:right;}
    form#numperPageFrm{display:inline;}
</style>

<section id="memberList-container">
	<h2>회원관리</h2>
	<div id="search-container">
		검색타입 : 
		<select id="searchType">
			<option value="userId" <%=searchType!=null&&searchType.equals("userId")?"selected":"" %>>아이디</option>
			<option value="userName" <%=searchType!=null&&searchType.equals("userName")?"selected":"" %>>회원이름</option>
			<option value="gender" <%=searchType!=null&&searchType.equals("gender")?"selected":"" %>>성별</option>
		</select>
		<div id="search-userId">
			<form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
				<input type="text" name="searchKeyword" size="25"
				placeholder="검색할 아이디를 입력해주세요"
				value="<%=searchType!=null&&searchType.equals("userId")?searchKeyword:""%>">
				<input type="hidden" name="searchType" value="userId">
				<button type="submit">조회</button>
			</form>
		</div>
		<div id="search-userName">
			<form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
				<input type="text" name="searchKeyword" size="25"
				placeholder="검색할 회원이름을 입력해주세요"
				value="<%=searchType!=null&&searchType.equals("userName")?searchKeyword:""%>">
				<input type="hidden" name="searchType" value="userName">
				<button type="submit">조회</button>
			</form>
		</div>
		<div id="search-gender">
			<form action="<%=request.getContextPath() %>/admin/searchMemberList" method="post">
				<label><input type="radio" name="searchKeyword"
				value="M"
				<%=searchType!=null&&searchType.equals("gender")&&searchKeyword.equals("M")?"checked":""%>>남</label>
				<label><input type="radio" name="searchKeyword"
				value="F"
				<%=searchType!=null&&searchType.equals("gender")&&searchKeyword.equals("F")?"checked":""%>>여</label>
				<input type="hidden" name="searchType" value="gender">
				<button type="submit">조회</button>
			</form>
		</div>
		<div id="numPerpage-container">
		페이지당 회원수:
		<form id="numPerFrm" action="">
			<select name="numPerpage" id="numPerpage">
				<option value="10">10</option>
				<option value="5" selected>5</option>
				<option value="3">3</option>
			</select>
		</form>
		</div>
	</div>
	<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<%if(list.isEmpty()){ %>
				<tr>
					<td colspan="9">조회된 회원이 없습니다</td>
				</tr>
			<%}else{ 
				for(Member m : list){%>
					<tr>
						<td><%=m.getUserId() %></td>
						<td><%=m.getUserName() %></td>
						<td><%=m.getGender() %></td>
						<td><%=m.getAge() %></td>
						<td><%=m.getEmail() %></td>
						<td><%=m.getPhone() %></td>
						<td><%=m.getAddress() %></td>
						<td><%=m.getHobby() %></td>
						<td><%=m.getEnrollDate()%></td>
					</tr>	
				<%} 
			 }%>
		</tbody>
	</table>
	<div id="pageBar">
		<%=request.getAttribute("pageBar") %>
	</div>
	<script>
		$("#searchType").change(e=>{
			const userId=$("#search-userId");
			const userName=$("#search-userName");
			const gender=$("#search-gender");
			
			userId.css("display","none");
			userName.css("display","none");
			gender.css("display","none");
			
			$("#search-"+$(e.target).val()).css("display","inline-block");
		});
		$(function(){
			$("#searchType").change();
		})
	
	</script>
</section>


<%@ include file="/views/common/footer.jsp"%>