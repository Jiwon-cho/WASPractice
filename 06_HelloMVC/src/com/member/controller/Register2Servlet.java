package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;

/**
 * Servlet implementation class Register2Servlet
 */
@WebServlet("/register2")
public class Register2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m=new Member();
		m.setUserId(request.getParameter("userId"));
		m.setPassword(request.getParameter("password"));
		m.setUserName(request.getParameter("userName"));
		m.setGender(request.getParameter("gender"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setAddress(request.getParameter("address"));
		String[] hobbies=request.getParameterValues("hobby");
		String h=String.join(",", hobbies);
		m.setHobby(h);
		int result=new MemberService().register(m);
		
		//클라이언트에게 보여줄 페이지 선택
		String msg="";
		String loc="";
		if(result>0) {
			//회원가입성공
			msg="회원가입 성공";
			loc="/";
		}else {
			//실패
			msg="회원가입 실패";
			loc="/register";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		RequestDispatcher rd=request.getRequestDispatcher("/views/common/msg.jsp");
		rd.forward(request, response);

	}
	
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
