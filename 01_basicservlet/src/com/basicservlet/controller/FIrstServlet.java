package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 규약을 준수하여 작성
//일반 클래스를 서블릿으로 만들기
//1. javax.servlet.http.HtpSErvlet 클래스를 상속받는다.
//2. 서블릿으로 client 의  요청을 받아 처리하는 메소드를 재정의 한다.
// 1) doGet() : 요청방식이 Get방식일 때 호출되는 매소드
// 2) doPost() : 요청방식이 Post방식일 때 호출 되는 메소드
//	*두 매소드를 정의할 때 두개의 Exception 처리를 함 ServletException, IOException



public class FIrstServlet extends HttpServlet{

	private static final long serialVersionUID = -8904665261417285029L;
	//데이터 주고 받아서 serializable
	
	public FIrstServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		
		System.out.println("내가 만든 첫 서블릿");
		
//		응답 페이지 작성하기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.write("<body>");
		out.write("<h1>내가 응답한것</h1>");
		out.write("</body>");
		out.print("</html>");
	}

	


}
