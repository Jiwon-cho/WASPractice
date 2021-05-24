package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.service.AdminService;
//import com.common.AESEncrypt;
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
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		int numPerpage;
		try {
			numPerpage=Integer.parseInt(request.getParameter("numPerpage"));
		}catch(NumberFormatException e) {
			numPerpage=5;
		}
		
		String type=request.getParameter("searchType");
		String keyword=request.getParameter("searchKeyword");
		
		List<Member> list=new AdminService().selectSearchMember(cPage,numPerpage,type,keyword);
//		for(Member m: list) {
//			try {
//				m.setPhone(AESEncrypt.decrypt(m.getPhone()));
//				m.setEmail(AESEncrypt.decrypt(m.getEmail()));
//			}catch(Exception e) {}
//		}
		int totalData=new AdminService().selectSearchMemberCount(type,keyword);
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		
		int pageBarSize=5;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		String pageBar="";
		
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/admin/searchMemberList?cPage="+(pageNo-1)
			+"&searchType="+type+"&searchKeyword="+keyword+"'>[이전]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/admin/searchMemberList?cPage="+pageNo
				+"&searchType="+type+"&searchKeyword="+keyword+"'>"
				+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/admin/searchMemberList?cPage="+pageNo
			+"&searchType="+type+"&searchKeyword="+keyword+"'>[다음]</a>";
		}
		request.setAttribute("pageBar", pageBar);		
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/admin/memberList.jsp")
		.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
