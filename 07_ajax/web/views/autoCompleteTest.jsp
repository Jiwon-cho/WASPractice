<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax로 자동완성 기능 구현하기</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2>이름 검색 자동완성 기능 구현하기</h2>
	<input type="text" id="nameSearch" list="list">
	<datalist id="list">
	</datalist>
	<script>
	$("#nameSearch").keyup(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajax/search.do",
			data:{"keyword":$(e.target).val()},
			success:data=>{
				$("#list").html("");
				console.log(data);
				const op=data.split(",");
				for(let i=0;i<op.length;i++){
					let option=$("<option>");
					option.val(op[i]);
					option.html(op[i]);
					$("#list").append(option);
					
				}
			}
		});
	});
	</script>
</body>
</html>