<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2>jquery 방식으로 ajax데이터 처리하기</h2>
	<!-- 서버에 있는 파일의 내용을 ajax로 불러오기 -->
	<button id="btnAjax">실행</button>
	<button id="btn">서블릿 호출하기</button>
	<div id="container"></div>
	<script>
	$("#btn").click(e=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/ajaxGetTest.do",
			type:"get",
			data:{name:"조지원",age:"19"},
			sucess:data=>{
				console.log("통신완료");
				console.log(data);
			}
			
		})
	})
	$("#btnAjax").click(e=>{
		//jquery 방식의 ajax 적용하기
		$.ajax({
			//요청할 주소속성 설정
			url:"sample.txt",
			//요청방식(get,post)
			type:"get",
			//서버에 전송할 데이터 -> 객체로 전송
			//data:{키:값,키:값..},
			//응답받는 데이터 형식지정 -> text, html, json, xml
			dataType: "text",
			//정상적으로 통신이 완료됬을때 실행될 로직 지정
			//로직(함수)의 매개변수로 서버에서 응답한 데이터를 받음
			success:data=>{
				console.log("통신완료");
			$("#container").html(data);
			}, //불러온 데이터가 여기로 들어옴
			//비정상적인 통신->에러 발생시 실행 로직 지정
			error:(r,m,s)=>{
				console.log(r);
				console.log(m);
				console.log(s);
			},
			//무조건 실행되는 함수
			//complete:()->{}
		});
	});
	</script>
</body>
</html>