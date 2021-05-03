package com.servlet.data.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UseDataServlet
 */
@WebServlet("/useData.do")
public class UseDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//저장된 데이터를 가져오기 위해서는 저장된 곳의 객체를 불러옴
		ServletContext context=request.getServletContext();
		HttpSession session=request.getSession();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<ul>");
		out.write("<li><h1> context: "+context.getAttribute("context")+"</h1></li>");
		out.write("<li><h1> session: "+session.getAttribute("session")+"</h1></li>");
		out.write("<li><h1> request: "+request.getAttribute("request")+"</h1></li>");
		out.write("<button onclick='location.assign(\"sessionout.do\")';'>세션 종료</button>");
		out.write("</ul>");
		out.write("</body>");
		out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
