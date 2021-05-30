package com.ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ajax.model.vo.Person;

/**
 * Servlet implementation class JsonTestServlet
 */
@WebServlet("/ajax/jsonTest.do")
public class JsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person p=new Person("박보검","0102293020","parkBogum.jpg");
		//Json방식으로 파싱 처리해줄 객체를 이용 -> json-simple 라이브러리 에서 만듬
		//{키:값,키:값,..} <= 자바 객체를 문자열로 앞에 형식으로 만들어주는 클래스
		//"{"+"키"+":"+"값"+","+"키"...+}"
		//JSONOBject 클래스를 이용하여 데이터를 넣어 파싱함
		JSONObject jo=new JSONObject();
		//각 맴버변수에 잇는 값을 세팅
		//JSONObject 의 put 메소드를 이용해서 key, value 형식으로 저장
		jo.put("name", p.getName());
		jo.put("phone", p.getPhone());
		jo.put("profile", p.getProfile());
		jo.put("age", 20);
		jo.put("height", 180.5);
		jo.put("flag", true);
		
		
		
		//json파일을 전송할 때는 contentType을 application/json
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
