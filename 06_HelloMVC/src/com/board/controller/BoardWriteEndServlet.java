package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardWriteEndServlet
 */
@WebServlet("/board/boardWriteEnd")
public class BoardWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg","잘못된 접근입니다.");
			request.setAttribute("loc", "/board/boardList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path=getServletContext().getRealPath("/upload/board/");
		MultipartRequest mr=new MultipartRequest(request,path,1024*1024*200,"utf-8",new DefaultFileRenamePolicy());
		Board b=new Board();
		b.setBoardTitle(mr.getParameter("boardTitle"));
		b.setBoardWriter(mr.getParameter("boardWriter"));
		b.setBoardContent(mr.getParameter("boardContent"));
		b.setBoardRenamedFilename(mr.getFilesystemName("upfile"));
		b.setBoardOriginalFilename(mr.getOriginalFileName("upfile"));
		
		int result=new BoardService().insertBoard(b);
		
		String msg="";
		String loc="";
		if(result>0) {
			 msg="게시물이 등록되었습니다.";
			 loc="/board/boardList";
		}else {
			msg="게시물 등록이 실패하였습니다.";
			loc="/board/boardWrite";
			
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
