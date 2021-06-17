package com.arduino.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LedController
 */
@WebServlet("/ledController")
public class LedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//다른 서버에 요청을 보낼 수 있음.
		//HttpURLConnection 클래스를 이용하면 가능하다.
		URL url=new URL("http://192.168.0.19/"+request.getParameter("addr")+"?led="+request.getParameter("led"));
		
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		
		InputStream is=conn.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		
		StringBuilder sb=new StringBuilder();
		String data="";
		while((data=br.readLine())!=null) {
			sb.append(data);
		}
		
		System.out.println(sb);
		br.close();
		conn.disconnect();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
