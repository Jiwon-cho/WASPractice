package com.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//Wrapper클래스를 만드려면 extends HttpServletRequestWrapper 한다.
public class MyWrapper extends HttpServletRequestWrapper {
	//Wrapper 클래스의 목적..?
	//HttpServletRequset객체가 제공하는 메소드를 커스터마이징 위해
	//내가 사용하고 싶은 방법으로 변경할 수 있게 해줌
	public MyWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String basicVal=super.getParameter(name);//기본 파라미터 정보를 가져옴
		return basicVal+" -gw-";
	}
}
