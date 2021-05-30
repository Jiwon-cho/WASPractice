package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.admin.model.service.AdminService;
import com.google.gson.Gson;
import com.member.model.vo.Member;

/**
 * Servlet implementation class MemberSearchAjaxServlet
 */
@WebServlet("/ajax/searchid.do")
public class MemberSearchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("keyword");
		
		List<Member> list=new AdminService().selectSearchMember(1,50,"userId",userId);
		
//		JSONObject jo=new JSONObject();
//		if(list.size()>0) {
//			Member m=list.get(0);
//			jo.put("userid", m.getUserId());
//			jo.put("username", m.getUserName());
//			jo.put("gender", m.getGender());
//			jo.put("age", m.getAge());
//			jo.put("email", m.getEmail());
//		}
		
		//List데이터 보내기
		//JSONArry 클래스를 제공하 -> JSONObject를 리스트 형식으로 저장하는 쿨래스
//		
//		JSONArray jr=new JSONArray();
//		for(Member m:list) {
//			JSONObject jo=new JSONObject();
//			jo.put("userid", m.getUserId());
//			jo.put("username", m.getUserName());
//			jo.put("gender", m.getGender());
//			jo.put("age", m.getAge());
//			jo.put("email", m.getEmail());
//			jo.put("enrolldate", m.getEnrollDate()); //Date-> Object X / parserror 뜸
//			jr.add(jo);
//		}
//		

		
		response.setContentType("application/json;charset=utf-8");
		/* response.getWriter().print(jo); */
//		response.getWriter().print(jr);
		new Gson().toJson(list.get(0),response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
