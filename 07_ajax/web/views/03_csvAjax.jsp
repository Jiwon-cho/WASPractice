<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>csv데이터를 ajax통신으로 가져오기</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2>csv데이터 가져오기</h2>
	<p>데이터를 특수기호 나워서 표현한 문자열의미함.</p>
	<button id="btn">데이터 가져오기</button>
	<div id="target"></div>
	<script>
		$("#btn").click(e=>{
			$.ajax({
				url:"<%=request.getContextPath()%>/ajax/csvTest.do",
				dataType:"text",
				success:data=>{
					console.log(data);
					const table=$("<table>");
					const persons=data.split("\n");
					console.log(persons);
					for(let i=0;i<persons.length;i++){
						let pData=persons[i].split(",");
						console.log(pData);
						let tr=$("<tr>");
						let name=$("<td>").html(pData[0]);
						let phone=$("<td>").html( pData[1]);
						let profile=$("<td>").append($("<img>").attr({
							"src":"<%=request.getContextPath()%>/images/"+pData[2],
							"width":"100px",
							"height":"100px"
						}));
						tr.append(name).append(phone).append(profile);
						table.append(tr);
						$("#target").html(table);
					}
				}
			});
		});
	</script>
	



</body>
</html>




