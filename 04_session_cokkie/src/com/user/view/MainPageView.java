package com.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainPageView
 */
@WebServlet("/mainPage.do")
public class MainPageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String html="<html>";
		html+="<head>";
		html+="<style> "
				+ "ul>li{display:inline-block;margin-right:20px;font-size:25px;font-weight:bolder;}"
				+ "</style>"
				+ "<body>"
				+ "<h1>GW홈페이지에 오신것을 환영합니다.</h1>";
		HttpSession session=request.getSession();
		if(session!=null && session.getAttribute("loginId")!=null) {
			//로그인 성공했을 ㄸㅐ화면
			html+="<ul>"
					+ "<li>메인화면</li>"
					+ "<li>갤러리</li>"
					+ "<li>게시판</li>"
					+ "</ul>"
					+ "<button onclick='location.replace(\""+request.getContextPath()+"/logout.do\")'>로그아웃</button>";
					
		}else {
			//로그인 실패했을 때 화면
			html+="<form action='login.do' method='post'>"
					+ "아이디<input type=\"text\" name=\"userId\"><br>\r\n"
					+ "패스워드<input type=\"password\" name=\"password\"><br>\r\n"
					+ "<input type=\"submit\" value=\"로그인\">\r\n"
					+ "</form>";
					
		}
		html+="</body></html>";
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
