package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AESEncrypt;
import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class MyinfoServlet
 */
@WebServlet("/memberView.do")
public class MyinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//역할! 클라이언트가 보낸 아이디하고 일치하는 회원의 정보를ㄹ 가져와
		//그 정보를 출력해주는 페이지와 연결
		String userId=request.getParameter("userId");
		
		Member m=new MemberService().selectMemberId(userId);
		
		//암호화된 자료를 복호화 처리
		try {
		m.setEmail(AESEncrypt.decrypt(m.getEmail()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			m.setPhone(AESEncrypt.decrypt(m.getPhone()));
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", m);
		
		request.getRequestDispatcher("views/member/myInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
