package com.wesocket.model.vo;

public class Message {
	String sender;
	String receiver;
	String msg;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(String sender, String receiver, String msg) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.msg = msg;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [sender=" + sender + ", receiver=" + receiver + ", msg=" + msg + "]";
	}
	

	
}
