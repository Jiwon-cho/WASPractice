package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트가 보낸 userId, password값이 DB에 있는지 확인하고 있으면
		//로그인, 없으면 로그인 실패처리하는 서비스!
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		//DB연결해보자
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean result=false;
		
		try {	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement("select * from member where member_id=? and member_pwd=?");
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) result=true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	String path="";
	if(result) {
		//로그인 성공
		//로그인에 성공을 하면 그 값을 유지하기 위해 session객체에 데이터를 대입
		HttpSession session=request.getSession();
		session.setAttribute("loginId", userId);
		path="mainPage.do";
	}else {
		//로그인 실패
		request.setAttribute("msg", "아이디와 비밀번호가 일치하지 않습니다.");
		path="msg.do";
	}
	RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		}
	

}
