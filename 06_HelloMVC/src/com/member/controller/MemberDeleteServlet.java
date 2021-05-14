package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/deleteMember")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트에서 전달받은 아이디와 동일한 Member테이블의 회원을 삭제하는 기능 수행
		//삭제 후 로그아웃 처리 후 메인 화면으로 이동
		//실패하면 다시 View 화면으로 이동하기
		
		String userId=request.getParameter("userId");
		int result=new MemberService().deleteMember(userId);
		String msg="";
		String loc="";
		if(result>0) {
			//삭제 성공했을 때
			//로그 아웃 처리후 메인으로 이동
//			request.getRequestDispatcher("/logout").forward(request, response);
			msg="탈퇴에 성공하셨습니다";
			loc="/logout";
		}else {
			//삭제 실패
			//회원 정보 화면으로 다시 이동
			msg="탈퇴에 실패하셨습니다.";
			loc="/memberView.do?userId="+userId;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
