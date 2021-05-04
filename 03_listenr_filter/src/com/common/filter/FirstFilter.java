package com.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터를 구현하기 위해서는 Filter인터 페이스를 구현해야한다.
//필터를 WAS에서 실행을 하려면 class 생성하고 등록을 해줘야함 == Servlet
//등록방법 2가지
//1. Web.xml를 이용해서 등록
//2. @Annotaion을 이용해서 등록하는 방법
public class FirstFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
	FilterChain filter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("내가만든 필터 실행");
		request.setCharacterEncoding("utf-8");
		//다음필터 또는 서블릿을 실
		filter.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

}
