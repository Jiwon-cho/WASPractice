package com.basicservlet.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life.do")//.do servlet에서 많이 쓰는 확장자
public class LifeServlet extends HttpServlet{

	
	private static final long serialVersionUID = -3636335934145972504L;

	public LifeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("doget 메소드호출");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		System.out.println("service매소드 호출");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		super.destroy();
		System.out.println("destory 매소드 호출");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init매소드 호출");
		super.init(config);
	}
 
	
}
