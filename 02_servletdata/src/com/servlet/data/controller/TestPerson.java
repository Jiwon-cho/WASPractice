package com.servlet.data.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPerson
 */
@WebServlet("/testPerson.do")
public class TestPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");

		//클라이언트가 전송한 데이터 받기
		//1. 기본데이터 받기(단일값) : request.getParameter("key);
		String name=request.getParameter("name");
		//다른 자료형으로 사용하려면 파싱처리해야한다. -> String -> int, String -> double
		//Integer, Double .. parseInt(), parseDouble()..
		int age=Integer.parseInt(request.getParameter("age")==null?"0":request.getParameter("age"));
		double height=Double.parseDouble(request.getParameter("height")==null?"0":request.getParameter("height"));
		
		String color=request.getParameter("color");
		//이렇게 가져오면 그냥 하나만 딱 가져오고 맘
		
		//여러개의 값의 parameter를 가져올 때
		//request.getParameterValues() -> 다중값을 가져올 때 사용
		//반환 -> String[]
		String[] foods=request.getParameterValues("food");
		// * 단일값도 getParameterValues() 매소드를 이용할 수 있다. -> 0번 인덱스에 대입
//		String[] na=request.getParameterValues("name");//이렇게도 가져올 수 있음 0번인덱스만 가져옴
		String animal=request.getParameter("animal");
		System.out.println(name+" : "+age+" : "+height+ " : "+color);
		for(String f: foods) {
			System.out.println(f);
		}
		System.out.println();
		
		
		//parameter의 값을 가져오는 다른 방법
		//key 값을 모를 때 key 값을 가져오는 방법
		//request.getParameterNames(); -> 클라이언트가 보낸 데이터의 모든 key값을 반환
		//반환형이 Enumberation객체(Iterator)
		ArrayList<String[]> parameterValues=new ArrayList();
		//key값으로 values를 가져와서 저장시키는 객체
		
		System.out.println("==========");
		Enumeration<String> keys=request.getParameterNames();
		while(keys.hasMoreElements()) {
//			System.out.println(keys.nextElement());
			String key=keys.nextElement();
			parameterValues.add(request.getParameterValues(key));
		}
		for(String[] v: parameterValues) {
			for(String pv:v) {
				System.out.println("값: "+pv);
			}
			System.out.println();
		}
		
		
		//클라이언트가 보낸 데이터의 key,value를 한번에 다 가져오기
		//Map 형태로 가져옴.
		//request.getParameterMap();
		Map<String, String[]>param=request.getParameterMap();
		System.out.println(param);
		
		Set<String> mkey=param.keySet();
		Iterator<String> ikey=mkey.iterator();
		while(ikey.hasNext()) {
			String k=ikey.next();
//			System.out.println(k+" : "+param.get(k));
			String temp="";
			for(String v: param.get(k)) {
				temp+=v+" ";
			}
			System.out.println(k+" : "+temp );
		}
		
		
		//응답페이지 작성하기
		//클라이언트 응답하기 위해서는 HttpServletResponse객체를 이용한다
		//response 객체는 응답하기 위한 각종 정보를 가지고 있는 객체이다.
		
		//1. 응답하는 방식을 결정 -> response.setContentType();
		//전송되는 데이터의 MIME 타입과 인코딩 방식을 결정
		response.setContentType("text/html;charset=utf-8");
		//2.클라이언트에게 데이터를(페이지내용을) 전송하기 위해 stream을 가져온다.
		// response.getWriter(): 문서(문자자체) / response.getOutputStream() : 바이너리파일(동영상,사진,일판파일,음악)
		PrintWriter out=response.getWriter();
		//응답할 페이지 구문을 작성해서 out 스트림에 보냄
		String html="<html>";
		html+="<body>";
		html+="<h1>당신의 이름은 "+name+"이고,<h1>";
		html+="<h2>당신의 나이는 "+age+"살, 키는 "+height+"cm이다.<h2>";
		html+="<p>당신이 좋아하는 색은<span style='color:"+color+"'> "+color+"</span>이고,</p>";
		html+="<ul>좋아하는 음식";
	for(String f : foods) {
//		html+="<li>"+f+"</li>";
		String src="";
		switch(f) {
		case "시리얼": src="data:image/jpeg;base64,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";break;
		case "가브리살":src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2769D74F534CF4380C"; break;
		case "갈비":src="https://recipe1.ezmember.co.kr/cache/recipe/2019/01/20/2e2fb5b6bff6f92142e1b6e702b911a11.jpg"; break;
		case "토다이":src="https://cdn.todaykorea.co.kr/news/photo/202102/283303_213716_1916.jpg"; break;
		case "계란초밥": src="https://recipe1.ezmember.co.kr/cache/recipe/2018/09/29/bc9e3809829df0e0560b25484bb620f81.jpg";break;
		}
		html+="<li><img src='"+src+"' height='200' width='200'></li>";
		
	}
	html+="</ul>";
	html+="<h3>종아하는 동물은 "+animal+"이다.</h3>";
	html+="<h4>이용해주셔서 감사합니다.</h4>";
	html+="<button onclick='history.back();'>뒤로가기</button>";
	html+="</body></html>";
	out.print(html);
	//out.write -> String 받음
		
		
		
//		 String name=request.getParameter("name");
//		 String age=request.getParameter("age");
//		 String height=request.getParameter("height");
//		String color=request.getParameter("color");
//		 String food=request.getParameter("food");
//		 String animal=request.getParameter("animal");
//		 System.out.println(name+" "+age+" "+height+" "+color+" "+food+" "+animal);
//		 response.setContentType("text/html;charset=utf-8");
//		 PrintWriter out=response.getWriter();
//		 String html="<html>";
//		 html+="<body>";
//		 html+="<h1>당신이 입력한 이름은 "+name+" 나이는 "+age+" 키는 "+height+" 색깔은 "+color+" 음식은 "+food+" 동물은 "+animal+"</h1>";
//		 html+="</body>";
//		 html+="</html>";
//		 out.write(html);
		
		
		
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
