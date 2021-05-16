package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
import com.common.AESEncrypt;
import com.member.model.vo.Member;

/**
 * Servlet implementation class searchMemberListServlet
 */
@WebServlet("/admin/searchMemberList")
public class searchMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("searchType");
		String keyword=request.getParameter("searchKeyword");
		
		List<Member> list=new AdminService().selectSearchMember(type,keyword);
		for(Member m: list) {
			try {
				m.setPhone(AESEncrypt.decrypt(m.getPhone()));
				m.setEmail(AESEncrypt.decrypt(m.getEmail()));
			}catch(Exception e) {}
		}
		request.setAttribute("list",list);
		
		
		
		request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
