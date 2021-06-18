package com.action.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.model.vo.Person;

/**
 * Servlet implementation class BasicElServlet
 */
@WebServlet("/basicEl")
public class BasicElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("p", new Person("유혜신",23,"서울구로구"));
		request.setAttribute("list", List.of(1,2,3,4,5,6,7));
		
		request.getSession().setAttribute("today", new Date());
		request.getSession().setAttribute("list", "이것도 리스트");
		
		getServletContext().setAttribute("userId","admin");
		getServletContext().setAttribute("p","피");
		request.getRequestDispatcher("/views/el/result.jsp")
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
