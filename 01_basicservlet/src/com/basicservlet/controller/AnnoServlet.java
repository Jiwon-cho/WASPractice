package com.basicservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//생성한 서블릿 클래스 어노테이션 방식으로 처리하기
//@WebServlet("주소값") -> class 선언부 위에 선언을 함.
//@WebServlet("/anno")//주소값 추소되는 거니까 적고 서버 내렸다 다시 올림
@WebServlet(name="anno",urlPatterns= {"/anno"})
//이름 지정 방법 /안적으면 임의의 이름이 부여됨
public class AnnoServlet extends HttpServlet{


	private static final long serialVersionUID = 4734249908953990659L;

	public AnnoServlet() {
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		System.out.println("어노테이션으로 연결된 서블릿");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.write("<body>");
		out.write("<h1>어노테이션으로 연결된 서블릿</h1>");
		out.write("</body>");
		out.print("</html>");
		
	}
	

}
