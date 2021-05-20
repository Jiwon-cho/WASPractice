package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.service.BoardService;
import com.board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//읽었는지 안읽었는지 체킹
		//cookie에 읽은 게시글의 번호를 저장해놓고 관리하자
		
		int no=Integer.parseInt(request.getParameter("no"));
		boolean readFlag=false; //안읽음
		//글번호를 저장할 변수
		String boardReadNo="";
		Cookie[] cookies=request.getCookies();	
		 if(cookies!=null) {
			 for(Cookie c: cookies) {
				 String name=c.getName(); //키 값
				 String value=c.getValue();// 값
				 if(name.equals("boardReadNo")) {
					 if(value.contains("|"+no+"|")) {
						 readFlag=true;
 						 break;
					 }
					 boardReadNo=value;//현재 읽은 게시글 번호
				 }
				 
			 }
		 }
		 //읽지 않은 글이면 쿠기글에 추가하기 위한 로직
		 if(!readFlag) {
			 Cookie c=new Cookie("boardReadNo",boardReadNo+"|"+no+"|");
			 c.setMaxAge(-1);
			 response.addCookie(c);
		 }
		 
		 Board b=new BoardService().selectBoard(no,readFlag);	
		 
		String view="";
		if(b==null) {
			request.setAttribute("msg", "조회한 게시물이 없습니다!");
			request.setAttribute("loc", "/board/boardList");
			view="/views/common/msg.jsp";
		}else {
			request.setAttribute("board", b);
			view="/views/board/boardView.jsp";
		}
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
