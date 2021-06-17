<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h1>기본 아두이노 서버 접속하기</h1>
	<!-- <a href="http://192.168.0.19">아두이노 접속</a> -->
	<button id="arduino">아두이노 서버 접속</button>
	<!-- <button ID="ledOn">집 전등 켜기</button>
		<button ID="ledOff">집 전등 끄기</button> -->
	<label><input type="radio" value="on" name="led">led 켜기</label>
		<label><input type="radio" value="off" name="led">led 끄기</label>
		<label><input type="radio" value="on" name="speaker">speaker 켜기</label>
		<label><input type="radio" value="off" name="speaker">speaker 끄기</label>
	<div id="container"></div>
	
	<script>
	$("[name=speaker]").click(e=>{
		$.get("<%=request.getContextPath()%>/ledController?addr=speaker&led="+$(e.target).val()
				,data=>{
			console.log(data);
			alert('SPEAKER '+$(e.target).val()+' 성공');
		});
	});
	
	
	$("[name=led]").click(e=>{
		$.get("<%=request.getContextPath()%>/ledController?addr=led&led="+$(e.target).val()
				,data=>{
			console.log(data);
			alert('LED '+$(e.target).val()+' 성공');
		});
	});

	
	
/* 	$("#LedOn").click(e=>{
		location.assign("http://192.168.0.19?test=on");
		alert("led켜짐");
		child.close();
	});
	
	
		$("#LedOff").click(e=>{
		location.assign("http://192.168.0.19?test=off");
		alert("led꺼짐");
		child.close();
		})
	 */
	
	
	
	$("#arduino").click(e=>{
		$.get("http://192.168.0.19",data=>{
			console.log(data);
		})
	})
	
	
	
	</script>
	
</body>
</html>