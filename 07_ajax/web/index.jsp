<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript-ajax</title>
</head>
<body>
	<h2>javascript를 이용한 ajax 통신</h2>
	<p>js를 이용해서 비동기식으로 서버와 통신하는 기술</p>
	<input id="name" type="text">
	<input id="age" type="text">
	
	<button onclick="ajaxTestGet();">get방식으로 ajax통신하기</button>
	<button onclick="location.href='<%=request.getContextPath()%>/ajaxGetTest.do?name=조지원'">기본요청</button>
	<!-- 기본요청으로 넘기면 새로 넘겨짐 -->
	<button onclick="ajaxTestPost();">post방식으로 ajax통신하기</button>
	
	<div id="container"></div>

<script>
	const ajaxTestPost=()=>{
		const xhr=new XMLHttpRequest();
		xhr.open("post","<%=request.getContextPath()%>/ajaxGetTest.do");
		xhr.onreadystatechange=()=>{
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.querySelector("#container").innerHTML+=xhr.responseText;
				}
				
			}
		}//onreadystatechange닫기
		//포스트 방식으로 전송했을 때 데이터를 보내려면
		//send()매개변수로 데이터 전송을 함.
		//전송하기 전 header의 contentType 내용을 변경해줘야함.
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		const name=document.querySelector("#name").value;
		const age=document.querySelector("#age").value;
		xhr.send("name="+name+"&age="+age);
		
	
	}





	const ajaxTestGet=()=>{
		//js로 ajax 통신하기
		//ajax 통신을 하기 위해서는 통신 처리를 하는 XMLHttpRequest객체를 만들어줌
		const xhr=new XMLHttpRequest();
		//1. open함술르 이용해서 요청방식, 요청주소, 동기,비동기 설정
		xhr.open("get","<%=request.getContextPath()%>/ajaxGetTest.do?name=조지원");
		
		//2. 요청에 대한 서버의 응답을 처리할 함수를 지정/ 설정
		//이벤트 방식으로 처리를 함 -> onreadystatechange 속성에 설정
		//xhr에서 관리하는 상태 2가지가 있음
		//1) readyState : 전송 상태를 관리 0~4(완료)
		//2) status: 서버의 응답결과(코드) -> 200(정상),404,500,403
		xhr.onreadystatechange=()=>{
			//서버로 부터 응답을 받았을 때 처리하는 로직을 구현
			//readyState(4)/status(200) 의 값에 따라 처리
			//정상적으로 데이터가 처리된 순간/ 그외는 에러니까 걸러주려고
			if(xhr.readyState==4){
				if(xhr.status==200){
					/* alert("데이터 전송 완료!"); */
					//서버에서 응답한 데이터는
					//xhr객체의 responseText속성에 저장됨. (자동)
					console.log("data :"+xhr.responseText);
				const data=xhr.responseText;
					document.querySelector("#container").innerHTML+=data;
				}
			}
			
		}
		
		//3. 설정한 대로 요청을 전송함
		xhr.send();
	}
</script>
	
</body>
</html>