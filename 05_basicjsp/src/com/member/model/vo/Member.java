package com.member.model.vo;

public class Member {
	private String userId;
	private String password;
	private String name;
	private int point;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Member(String userId, String password, String name, int point) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.point = point;
	}
	/**
	 * 
	 */


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
}
