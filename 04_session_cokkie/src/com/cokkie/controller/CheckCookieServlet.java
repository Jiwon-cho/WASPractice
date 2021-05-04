package com.cokkie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCookieServlet
 */
@WebServlet("/checkcookie.do")
public class CheckCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//저장된 쿠키 가져오기
		//저장된 쿠키는 배열로 request객체의 메소드를 이용해서 가져옴->한줄 쫙 가져옴
		response.setContentType("text/html;charset=utf-8");
		String html="<html>";
		html+="<body>";
		html+="<ul>";
		Cookie[] cookies=request.getCookies();
		
		for(Cookie c: cookies) {
			//Cookie 값은 getName() -> key /getValue() - value의 값을 가져올 수 있음
			html+="<li>"+c.getName()+" : "+c.getValue()+"</li>";
			System.out.println("key : "+c.getName()+" : value: "+c.getValue());
		}
		
		html+="</ul>";
		html+="<h3><a href='deleteCookie.do'>쿠키지우기</a></h3>";
		html+="</body>";
		html+="</html>";
		response.getWriter().print(html);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
