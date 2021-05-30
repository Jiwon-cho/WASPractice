package com.websocket.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.wesocket.model.vo.Message;

//웹소켓버서의 역할하는 클래스에는 @ServerEndoPoint(주소)
@ServerEndpoint(
		value="/chatting",
		encoders = {MessageEncoder.class},
		decoders = {MessageDecoder.class}
)
public class ChattingServer {
	private HashMap<String, Session> clients=new HashMap();
	@OnOpen
	public void open(Session session,EndpointConfig config) {
		System.out.println("클라이언트 접속");
		System.out.println(session.getId());
	}
	
	
	@OnMessage
	//public void message(Session session,String msg) {
	public void message(Session session, Message curMsg) {
		//System.out.println(msg);
		//client에 대한 정보를 유지하기 위해서
		//session.getUserProperties().put()
		//String[] curMsg=msg.split(",");
		
		//Message curMsg=new Gson().fromJson(msg, Message.class);		
		
		System.out.println(curMsg);
		
		session.getUserProperties().put("msg",curMsg);//sender,msg
		//String[] data=(String[])session.getUserProperties().get("msg");
		
		
		///clients.put(msg, session);
		//접속한 모든 세션에게 msg를 전송해보자.
		//접속한 모든 세션관리는 List,Set,Map
		//접속한 모든세션을 가져오는 매소드가 있음
		//getOpenSessions()-> Set<Session>
		Set<Session> clients=session.getOpenSessions();
		for(Session s : clients) {
			Message clientData=(Message)s.getUserProperties().get("msg");
			//0 : 보낸사람 / 1 : 받는사람 / 2 : 메세지
			//접속한 모든 session에 메세지 전송하기
			try {
				if(clientData!=null
					&&(clientData.getSender().equals(curMsg.getReceiver())
						||clientData.getSender().equals(curMsg.getSender()))) {
					//보낸사람이 받는사람과 같으면
					//접속한 session중 보낸사람(sender)의 데이터가 
					//현재 보내진 메세지의 받는사람과 같은 session필터링
					//s.getBasicRemote().sendText(msg);
					s.getBasicRemote().sendObject(curMsg);
				}else if(clientData!=null&&curMsg.getReceiver().equals("")) {
					//s.getBasicRemote().sendText(msg);
					s.getBasicRemote().sendObject(curMsg);
				}
				
			}catch(IOException|EncodeException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}

/*
 * package com.websocket.controller;
 * 
 * import java.io.IOException; import java.util.HashMap; import java.util.Set;
 * 
 * import javax.websocket.EncodeException; import
 * javax.websocket.EndpointConfig; import javax.websocket.OnError; import
 * javax.websocket.OnMessage; import javax.websocket.OnOpen; import
 * javax.websocket.Session; import javax.websocket.server.ServerEndpoint;
 * 
 * import com.wesocket.model.vo.Message;
 * 
 * //웹소켓 서버의 역할을 하는 클래스에는 @ServerEndpoint(주소)
 * 
 * @ServerEndpoint( value="/chatting", encoders= {MessageEncoder.class},
 * decoders= {MessageDecoder.class}) public class ChattingServer { private
 * HashMap<String, Session> clients=new HashMap();
 * 
 * @OnOpen public void open(Session session, EndpointConfig config) {
 * System.out.println("클라이언트 접속"); System.out.println(session.getId()); }
 * 
 * @OnMessage // public void message(Session session, String msg) public void
 * message(Session session, Message curMsg){ // System.out.println(msg); //
 * clients.put(msg, session); //session.getUserProperties().put() //String[]
 * curMsg=msg.split(","); //현재 메세지 // Message curMsg=new
 * Gson().fromJson(msg,Message.class);
 * 
 * System.out.println(curMsg); session.getUserProperties().put("msg",curMsg); //
 * session.getUserProperties().put("msg",msg.split(","));//sender,msg //msg 에
 * sender, msg 가 들어가서 그걸가지고 사용
 * 
 * 
 * //접속한 모든 세션에게 msg를 전송해보자. //접속한 모든 세션 //접속한 모든 세션 관리는 List, Set, Map //접속한 모든
 * 세션을 가져오는 매소드가 있음 //getOpenSession() -> Set<Session> Set<Session>
 * clients=session.getOpenSessions(); //내 세션에 접속한 세션 다 들어옴 for( Session s:
 * clients) { Message clientData=(Message)s.getUserProperties().get("msg");
 * 
 * 
 * // String[] clientData=(String[])s.getUserProperties().get("msg"); //0: 보낸사람
 * / 1: 받는사람 / 2: 메세지 //접속한 모든 session 메세지 전송하기 try {
 * if(clientData!=null&&(clientData.getSender().equals(curMsg.getReceiver())||
 * clientData.getSender().equals(curMsg.getSender()))) { //보낸사람이 받는 사람과 같으면
 * //접속한 session중 보낸 사람(sender)의 데이터가 //현재 보내진 메세지의 받는 사람과 같은 session 필터링 //내거
 * 보낸거 나한테도 보여야함 // s.getBasicRemote().sendText(msg);
 * s.getBasicRemote().sendObject(curMsg);
 * 
 * }else if(clientData!=null&&curMsg.getReceiver().equals("")) {
 * 
 * // s.getBasicRemote().sendText(msg); s.getBasicRemote().sendObject(curMsg);
 * 
 * }
 * 
 * }catch(IOException|EncodeException e) { e.printStackTrace(); } }
 * 
 * }
 * 
 * 
 * @OnError
 * 
 * public void onError(Throwable t) {
 * 
 * System.out.println("onError");
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * }
 */