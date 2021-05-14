<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 Member m=(Member)request.getAttribute("member");
String hobby[]=m.getHobby().split(",");
String[] checkedHobby=new String[5];
for(String h: hobby){
	switch(h){
	case "운동": checkedHobby[0]="checked";break;
	case "등산": checkedHobby[1]="checked";break;
	case "독서": checkedHobby[2]="checked";break;
	case "게임": checkedHobby[3]="checked";break;
	case "여행": checkedHobby[4]="checked";break;
	}
}
 %>

<%@ include file="/views/common/header.jsp" %>
<section id=enroll-container>
		<h2>회원 정보 수정</h2>
		<form id="memberFrm" method="post" >
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="userId" id="userId_" 
						value="<%=m.getUserId() %>">
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td>
						<input type="password" name="password" id="password_"
						value="<%=m.getPassword() %>">
					</td>
				</tr>
				<tr>
					<th>패스워드확인</th>
					<td>	
						<input type="password" id="password_2"><br>
					</td>
				</tr>  
				<tr>
					<th>이름</th>
					<td>	
					<input type="text"  name="userName" id="userName" 
					value="<%=m.getUserName() %>"required><br>
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>	
					<input type="number" name="age" id="age"
					value="<%=m.getAge() %>"><br>
					</td>
				</tr> 
				<tr>
					<th>이메일</th>
					<td>	
						<input type="email" placeholder="abc@xyz.com" name="email" id="email"
						value="<%=m.getEmail() %>"><br>
					</td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>	
						<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11"
						value="<%=m.getPhone() %>"><br>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>	
						<input type="text" placeholder="" name="address" id="address" 
						value="<%=m.getAddress() %>"><br>
					</td>
				</tr>
				<tr>
					<th>성별 </th>
					<td>
			<%-- 			<%  if(m.getGender().equals("M")){ %>
							<input type="radio" name="gender" id="gender0" value="M" checked>
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F">
							<label for="gender1">여</label>
						<%}else{ %>
						<input type="radio" name="gender" id="gender0" value="M" >
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F" checked>
							<label for="gender1">여</label>
						<%} %> --%>
						<input type="radio" name="gender" id="gender0" value="M" <%=m.getGender().equals("M")?"checked":"" %> >
							<label for="gender0">남</label>
							<input type="radio" name="gender" id="gender1" value="F" <%=m.getGender().equals("F")?"checked":"" %>>
							<label for="gender1">여</label>
					</td>
				</tr>
				<tr>
					<th>취미 </th>
					<td>
					<%-- 	<input type="checkbox" name="hobby" id="hobby0" value="운동" <%=checkedHobby[0] %> ><label for="hobby0">운동</label>
						<input type="checkbox" name="hobby" id="hobby1" value="등산" <%=checkedHobby[1] %>><label for="hobby1">등산</label>
						<input type="checkbox" name="hobby" id="hobby2" value="독서" <%=checkedHobby[2] %>><label for="hobby2">독서</label><br />
						<input type="checkbox" name="hobby" id="hobby3" value="게임" <%=checkedHobby[3] %>><label for="hobby3">게임</label>
						<input type="checkbox" name="hobby" id="hobby4" value="여행" <%=checkedHobby[4] %>><label for="hobby4">여행</label><br /> --%>
						<input type="checkbox" name="hobby" id="hobby0" value="운동" <%=m.getHobby().contains("운동")?"checked":"" %>><label for="hobby0">운동</label>
						<input type="checkbox" name="hobby" id="hobby1" value="등산" <%=m.getHobby().contains("등산")?"checked":"" %>><label for="hobby1">등산</label>
						<input type="checkbox" name="hobby" id="hobby2" value="독서" <%=m.getHobby().contains("독서")?"checked":"" %>><label for="hobby2">독서</label><br />
						<input type="checkbox" name="hobby" id="hobby3" value="게임" <%=m.getHobby().contains("게임")?"checked":"" %>><label for="hobby3">게임</label>
						<input type="checkbox" name="hobby" id="hobby4" value="여행" <%=m.getHobby().contains("여행")?"checked":"" %>><label for="hobby4">여행</label><br />

					</td>
				</tr>
			</table>
			<input type="button" value="정보수정" onclick="fn_updateMember();"/>
			<input type="button" value="탈퇴" onclick="fn_deleteMember();"/>
		</form>
	</section>
	<script>
	const fn_deleteMember=()=>{
		if(confirm("정말로 탈퇴하겠습니까?")){
			location.replace("<%=request.getContextPath()%>/deleteMember?userId=<%=m.getUserId()%>");
				}
	}
	
 const	fn_updateMember=()=>{
		const updateFrm=$("#memberFrm");
		updateFrm.attr("action","<%=request.getContextPath()%>/updateMember")
		//form을 전송하려면 submit()함수 실행
		updateFrm.submit();

	}
	</script>

<%@ include file="/views/common/footer.jsp"%>	
