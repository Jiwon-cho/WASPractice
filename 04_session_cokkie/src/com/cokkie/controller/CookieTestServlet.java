package com.cokkie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTestServlet
 */
@WebServlet("/cookietest.do")
public class CookieTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie c=new Cookie("dinner","제육볶음");
		Cookie c2=new Cookie("study","서블릿");
		//생성된 쿠키 설정하기
		c.setMaxAge(60*60*24);
		
		//cookie저장 응답하기
		response.addCookie(c);
		response.addCookie(c2);
		
		response.setContentType("text/html;charset=utf-8");
		String html="<html>";
		html+="<body>";
		html+="<p>쿠키를 저장했습니다</p>";
		html+="<button onclick='location.assign(\"checkcookie.do\");'>저장된 쿠키확인</button>";
		html+="</body>";
		html+="</html>";
//		일단 오리고보자
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
