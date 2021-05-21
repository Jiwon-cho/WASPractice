package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.BoardService;
import com.board.model.vo.Comment;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/board/insertComment")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String content=request.getParameter("content");
	int level=Integer.parseInt(request.getParameter("level"));
	String writer=request.getParameter("commentWriter");
	int boardRef=Integer.parseInt(request.getParameter("boardRef"));
	int commentRef=Integer.parseInt(request.getParameter("commentRef"));
	
	Comment c=new Comment(0,level,writer,content,boardRef,commentRef,null);
	
	int result=new BoardService().insertComment(c);
	String msg="";
	if(result>0) {
		msg="댓글 등록성공";
	}else {
		msg="댓글 등록 실패";
	}
	request.setAttribute("msg", msg);
	request.setAttribute("loc", "/board/boardView?no="+boardRef);
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
