<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON으로 데이터 받아오기</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
 <h2>json simple이용하기</h2>
<button id="getPerson">실행하기</button>

<input type="text" id="userId">
<button id="searchId">아이디 찾기</button>
<div id="result"></div>
<script>
$("#searchId").click(e=>{
	$.ajax({
		url:"<%=request.getContextPath()%>/ajax/searchid.do",
		data:{"keyword":$("#userId").val()},
		success:data=>{
			console.log(data);
			const table=$("<table>");
			const head=$("<tr>").html("<th>아이디</th><th>이름</th><th>성별</th><th>나이</th><th>이메일</th>");
			table.append(head);
			/* let body=$("<tr>");
			let id=$("<td>").html(data["userid"]);
			let name=$("<td>").html(data["username"]);
			let gender=$("<td>").html(data["gender"]);
			let age=$("<td>").html(data["age"]);
			let email=$("<td>").html(data["email"]);
			body.append(id).append(name).append(gender).append(age).append(email);
			$("#result").append(table.append(head).append(body)); */
			$.each(data,(i,v)=>{
				let body=$("<tr>");
				let id=$("<td>").html(v["userid"]);
				let name=$("<td>").html(v["username"]);
				let gender=$("<td>").html(v["gender"]);
				let age=$("<td>").html(v["age"]);
				let email=$("<td>").html(v["email"]);
				body.append(id).append(name).append(gender).append(age).append(email);
				table.append(body);
			});
				$("#result").html(table);
		},error:(r,s,m)=>{
			console.log(s);
		}
		
	})
})
</script>

</body>
<script>
	$("#getPerson").click(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/jsonTest.do",
			dataType:"json",
			success:data=>{
				console.log(data);
				const ul=$("<ul>");
				const li=$("<li>").html(data["name"]);
				const li1=$("<li>").html(data["phone"]);
				const li2=$("<li>").html(data["profile"]);
				const li3=$("<li>").html(data["age"]);
				const li4=$("<li>").html(data["height"]);
				ul.append(li).append(li1).append(li2).append(li3).append(li4);
				$(e.target).after(ul);
			},error:(r,s,m)=>{
				console.log(r);
				console.log(s);
				
			}
			
		})	
	
	
	})



</script>
</html>