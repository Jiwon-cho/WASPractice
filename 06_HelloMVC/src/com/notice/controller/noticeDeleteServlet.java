package com.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notice.model.service.noticeService;

/**
 * Servlet implementation class noticeDeleteServlet
 */
@WebServlet("/notice/deleteNotice")
public class noticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no=Integer.parseInt(request.getParameter("no"));
		String filePath=request.getParameter("filepath");
		int result=new noticeService().deleteNotice(no);
		
		String msg="";
				
		if(result>0) {
			
			msg="공지사항이 삭제되었습니다.";
			String path=getServletContext().getRealPath("/uplaod/notice/");
			File f=new File(path+filePath);
			if(f.exists()) {
				f.delete();
			}
		}else {
			msg="공지사항 삭제에 실패하였습니다.";
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/notice/noticeList");
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
