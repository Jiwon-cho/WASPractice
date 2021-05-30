package com.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet(name = "binsert", urlPatterns = { "/binsert" })
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Board b=new Board();
		b.setBoardTitle(request.getParameter("boardTitle"));
		b.setBoardWriter(request.getParameter("boardWriter"));
		b.setBoardContent(request.getParameter("boardContent"));
		
		int result=new BoardService().insertBoard(b);
		
		String message="";
		String view="";
		if(result>0) {
			view="/blist";
		}else {
			message="게시물 등록 실패.";
			view="/views/common/error.jsp ";
			
		}
		request.setAttribute("message", message);

		request.getRequestDispatcher(view).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
