<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본채팅구성하기</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	#msgContainer{
		height:500px;
	}
</style>
</head>
<body>
	보내는사람 <input type="text" id="sender" size="8"><br>
	받는 사람 <input type="text" id="receiver" size="8"><br>
	<input type="text" id="msg" placeholder="전송할 메세지 입력">
	<button id="sendMsg">메세지 전송</button>
	<div id="msgContainer"></div>
	<script>
		//웹소켓을 이용하기 위한 웹소켓 객체 생성
		const socket=new WebSocket("ws://localhost:9090/<%=request.getContextPath()%>/chatting");
		//주소작성 : ws://서버주소 -> http통신
		//주소작성 : wss://서버주소 -> https통신
		
		//각 이벤트속성 설정하기
		socket.onopen=e=>{
			//alert('웹소켓서버접속 완료');
			console.log(e);
		}
		
		socket.onmessage=e=>{
			//서버에서 전송한 데이터를 수신하고 페이지에 적용하는 함수
			console.log(e);
			//전송온 데이터를 파싱처리하기
			/* let data=e.data.split(",");
			console.log(data); */
			//자바스크립트 객체 형식으로 넘어온 문자열은 객체로 변환할 수 있다.
			//JSON.parse()함수이용함.
			console.log(JSON.parse(e.data));
			let data=JSON.parse(e.data);
			let msg;
			if($("#sender").val()==data["sender"]){
				//자신
				msg=$("<h3>").html(data["sender"]+" : "+data["msg"]).css({
					"text-align":"left",
					"background-color":"gold"
				});
			}else{
				//상대방
				msg=$("<h3>").html(data["sender"]+" : "+data["msg"]).css({
					"text-align":"right",
					"background-color":"cornflowerblue"
				});
			}
			$("#msgContainer").append(msg);
		}
	
		
		$("#sendMsg").click(e=>{
			const sendMsg=new Message($("#sender").val(),
					$("#receiver").val(),$("#msg").val());
			socket.send(JSON.stringify(sendMsg));//서버의 @OnMessage메소드가 실행
		})
		
		function Message(sender, receiver, msg){
			this.sender=sender;
			this.receiver=receiver;
			this.msg=msg;
		}
		
		
	
		socket.onclose=e=>{
			console.log(e);
		}
	</script>

</body>
</html>










<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 채팅 구성하기</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
보내는 사람<input type="text" id="sender" size="8">
받는 사람<input type="text" id="receiver" size="8">
<input type="text" id="msg" placeholder="전송할 메세지 입력">
<button id="sendMsg"> 메세지 전송</button>
<div id="msgContainer"></div>
<script>
//웹소켓을 이용하기 위한 웹소켓 객체 생성
const socket=new WebSocket("ws://localhost:9090/<%=request.getContextPath()%>/chatting");
//주소작성 : ws:// 서버주소 -> http통신
//주소작성 : wss://서버주소 -> https통신

//각 이벤트 속성 설정하기 
socket.onopen=e=>{
/* 	alert('웹소켓 서버 접속 완료'); */
	console.log(e);
	
}

socket.onmessage=e=>{
	//서버에서 전송한 데이터를 수신하고  페이지에 적용하는 함수
	console.log(e);
	
	//전송온 데이터를 파싱처리하기
	//let data=e.data.split(",");
	//console.log(data); 
	//자바스크립트 객체 형식으로 넘어온 문자열은 객체로 변환할 수 있다.
	//JSON.parse() 함수이용함
	console.log(JSON.parse(e.data));
	let data=JSON.parse(e.data);
	let msg;
	if($("#sender").val()==data["sender"]){
		//자신 
		msg=$("<h3>").html(data["sender"]+" : "+data["msg"]).css({
			"text-align":"left",
			"background-color":"gold"
		});
		
	}else{
		//상대방
		msg=$("<h3>").html(data["sender"]+" : "+data["msg"]).css({
			"text-align":"right",
			"background-color":"cornflowerblue"
		});
		
	}
	$("#msgContainer").append(msg);
	
	//$("#msgContainer").append($("<h3>").html(data[0] +" : "+data[1]));
	
}

socket.onclose=e=>{
	console.log(e);
	
}


$("#sendMsg").click(e=>{
	const sendMsg=new Message($("#sender").val(),
			$("#receiver").val(),$("#msg").val());
	socket.send(JSON.stringify(sendMsg));//서버의 @OnMessage메소드가 실행
	//이렇게 안하면 json 안됨.
})
	
function Message(sender ,receiver, msg){
		this.sender=sender;
		this.receiver=receiver;
		this.msg=msg;
		
	}

</script>
</body>
</html> --%>