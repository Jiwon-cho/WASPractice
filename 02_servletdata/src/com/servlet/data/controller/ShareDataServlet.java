package com.servlet.data.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShareDataServlet
 */
@WebServlet("/share.do")
public class ShareDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//was 에서 사용할 수 있는 데이터 저장 객체를 알아보자
		//1.SerVletContest: 서버실행시 부터 서버 종료시 까지
		//2.HttpSession: session 생성시 부터 session 종료시까지
		//3. HttpSErvletRequest: 요청된 순간부터 요청이 종료(응답할)될 때까지
		//ServletContext객체 생성
		ServletContext context=request.getServletContext();
		//HttpSession 객체 생성
		HttpSession session=request.getSession();
		
		//Object obj="contextData"; -> upcasting 자동으로 형변환되어 들어감.
		//String str=obj; -> downcasting 강제적 형변환을 해야함.
		
		//각 공유데이터 저장객체에 값을 넣을 때는 setAttribute() 메소드를 이용함
		context.setAttribute("context", "contextData");
		session.setAttribute("session", "sessionData");
		request.setAttribute("request", "requestData");
		
		//저장한 데이터 출력하기
		//저장된 데이터를 출력할 때는 저장된 key 값을 기준으로 출력함.
		//getAttribute("key") ->
		String contextValue=(String)context.getAttribute("context");
		System.out.println("context: "+contextValue);
		String sessionValue=(String)session.getAttribute("session");
		System.out.println("session: "+sessionValue);
		String requestValue=(String)request.getAttribute("request");
		System.out.println("reqeust: "+requestValue);
		
		
		//저장된 데이터를 변경, 삭제하기
		//변경: 같은 키값으로 다른 값을 넣으면 수정
//		System.out.println("request: "+requestValue);
//		request.setAttribute("requset", "요청데이터");
//		requestValue=(String)request.getAttribute("requset");
//		System.out.println(requestValue);
//		//삭제: removeAttribute("key");
//		request.removeAttribute("request");
//		requestValue=(String)request.getAttribute("request");
//		System.out.println("request: "+requestValue);
		//없는 키값을 넣으면 null 값을 출력함
		
		//페이지(서블릿) 이동시 객체활용
//		//1. RequestDispatcher객체를 이용해서 전환
//		RequestDispatcher rd=request.getRequestDispatcher("useData.do");
//		rd.forward(request, response);
		
		//2. sendRedirect로 전환하기
		response.sendRedirect("useData.do");
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
