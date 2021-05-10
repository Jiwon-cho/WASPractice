package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 데이터(id,pw)가 DB에 잇는지 확인후
		//로그인 처리하는 서비스
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		System.out.println("userId : "+userId+" password: "+password);
		
		//DB에 접속해서 ID,PW 맞는지 확인
		//-> 있으면 Member자체를 가져오고
		// 없으면 null값을 반환하는 로직으로 구성
		
		Member m=new MemberService().login(userId,password);
		
		 
		//m 이 null 이면, 로그인 실패
		//m 이 null 이 아니면 로그인 성공
		if(m!=null) {
			//로그인 성공
			//로그인한 객체를 저장하고 메인으로 이동
//			request.setAttribute("loginMember",m);
			//로그인 상태를 유지하기 위하여 세션에 저장
			HttpSession session=request.getSession();
			session.setAttribute("loginMember",m);
//			RequestDispatcher rd=request.getRequestDispatcher("/");
//			rd.forward(request, response);
	response.sendRedirect(request.getContextPath());		
			
		}else {
			//로그인 실패
			//로그인 실패 알람을 띄워주고 메인화면으로 이동
			String msg="아이디, 비밀번호가 일치하지 않습니다.";
			String loc="/";
			request.setAttribute("msg",msg);
			request.setAttribute("loc", loc);
			
			RequestDispatcher rd=request.getRequestDispatcher("/views/common/msg.jsp");
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
