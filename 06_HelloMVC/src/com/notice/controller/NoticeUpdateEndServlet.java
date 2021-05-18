package com.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.notice.model.vo.notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import oracle.net.aso.n;

/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/notice/updateNoticeEnd")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("mgs", "공지사항 수정 실패[form:enctype] X(");
			request.setAttribute("loc", "/notice/noticeList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/notice/");
		MultipartRequest mr=new MultipartRequest(request,path,1024*1024*10,
				"utf-8",new DefaultFileRenamePolicy());
		notice n=new notice();
		n.setNoticeTitle(mr.getParameter("noticeTitle"));
		n.setNoticeWriter(mr.getParameter("noticeWriter"));
		n.setNoticeContent(mr.getParameter("content"));
		
		String fileName=mr.getFilesystemName("up_file");
		//파일 처리하기
		File f=mr.getFile("up_file");
		
		if(f!=null&&f.length()>0) {
			//새로운 파일이전달됨
			//이전 파일을 삭제
			File del=new File(path+mr.getParameter("oldFile"));
			del.delete();
		}else {
			//새로운 파일이 없음
			fileName=mr.getParameter("oldFile");
		}
		
		n.setFilePath(fileName);
		//DB수정
		
		//화면 선택
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
