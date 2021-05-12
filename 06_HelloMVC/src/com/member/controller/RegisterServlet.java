package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	
//		Member m=new Member();
//		m.setUserId(request.getParameter("userId"));
//		m.setPassword(request.getParameter("passwrod"));
//		m.setUserName(request.getParameter("username"));
//		m.setGender(request.getParameter("gender"));
//		m.setAge(Integer.parseInt(request.getParameter("age")));
//		m.setEmail(request.getParameter("email"));
//		m.setPhone(request.getParameter("phone"));
//		m.setAddress(request.getParameter("address"));
//		String[] hobbies=request.getParameterValues("hobby");
//		String h="";
//		for(String s: hobbies) {
//			h+=s+", ";
//		}
//		m.setHobby(h);
		
//		
		//페이지 전환용
		//요청한 페이지를 반환
		RequestDispatcher rd=request.getRequestDispatcher("/views/member/Register.jsp");
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
