<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 첫 jsp 페이지</title>
</head>
<body>
	<h1>나의 첫 jsp 페이지</h1>
	<p>
		jsp 태그는 html 문서에 자바코드를 사용할 수 있게 하는 태그, 그 태그는
		&lt;%&gt;방식으로 사용 -> 태그에 %가 있으면 자바코드로 해석한다.
		기본 자바코드를 작성할 때는 스크립트태그를 이용 &lt;%&gt;임.
		지역변수, if문, for문, while문, switch문, 메소드 호출 등등...
		선언문 &lt;%!&gt; 자바코드를 작성할 때 사용
		멤버변수 선언, 메소드 선선을 할 때 사용
	</p>
	
	
	<h2>선언문 태그 이용하기</h2>
	<p>
		html문서에 자바코드를 사용할 때 이용하는 태그로 class 선언부에 사용해야하는 코드를 작성할 때 사용
	</p>
	<%!
	//선언문이다!
	//멤버변수로 변수 선언하기
	private String name="조지원";
	//메소드 선언
	public String printTest(){
		return "이제 쉬는 시간";
	}
	
	//선언문에서 지역변수 선언은 가능할까?
	int age;// -> default 접근제한자. 이검 멤버변수임
	
	//메소드 호출이 가능할
	//printTest(); 불가능함.
	
	//조건절 사용이 가능할까?
	/* if(name.equals("조지원"))) */
/* 	for(int i=0; i<10;i++){
		
	} 안됨*/

	%>
	<h2>선언문에 있는 내용 출력 -> 표현태그를 사용한다</h2>
	<h3>당신의 이름은 <%=name %></h3>
	<h3>당신의 나이는 <%=age %></h3>
	<h4>메세지: <%=printTest() %></h4>
	
	<h2>스크립트립 이용하기</h2>
	<p> 지역변수, 배소드 호출, if 문, switch문, for문 ,while 문.. 사용이 가능</p>
	<%
	//스크립트립 태그
	String address="경기도 의왕시";
	//접근 제한자 사용이 가능한가?
	//private double height; 지역 변수라 안됨
	
	//조건문을 사용할 수 있을까?
	if(name.equals("유지훈")){
		System.out.println("배고프다");
	}
	
	switch(name){
	case "유병승": System.out.println("r클래스 선생님");break;
	case "유지훈": System.out.println("r클래스 반장");break;
	default : System.out.println("r클래스 수강생");break;
	}
	
	for(int i=0;i<10;i++){
		System.out.println(i);
	}
	
	//메소드 호출 가능
	System.out.println(printTest());
	String[] dinner={"소세지","양념치킨","떡갈비","초코파이"};
	
	
	%>
	<h2>페이지 출력시 jsp 태그 이용하기</h2>
	<p>이름이 유지훈이면 R클래스 반장이다 출력</p>
	<%if(name.equals("유지훈")){%>
		<h2><%=name %>은 R클래스 반장이다!</h2>
		
<%	}else{ %>
	<h2><%=name %>은 수강생이다!</h2>
	<%} %>
<!-- TRUE 가 아니면 출력 안함 -->

<H3>오늘의 저녁 메뉴</H3>
<ul>
<%for(int i=0;i<dinner.length;i++){%>
<%if(dinner[i].length()>=4){ %>
	<li><%=dinner[i]%></li>
	
<%}}%>

</ul>


<h3>내장 객체 활용하기</h3>
<p>스크립트립 태그를 이용해서 활용한다</p>
<%
String[]hobbies=(String[])request.getAttribute("hobby");

session.setAttribute("userId","admin");
application.setAttribute("email","sksk@naver.com");
%>
<h3>request:<%=request %></h3>
<h3>session:<%=session%></h3>
<h3>application:<%=application %></h3>
 <%-- <h3>member:<%=member %></h3> 없는건 선언 못함 위에꺼들은 내장이라 있음--%>
<h4><a href="views/innerObj.jsp">내장객체 확인하기</a></h4>

<h4>반환된 내장객체 데이터 출력하기</h4>
<ul>
<li><%=request.getAttribute("request") %></li>
<li><span style="color:red"><%=session.getAttribute("session") %></li>
<li><%=application.getAttribute("application") %></li>
</ul>
	<%if(hobbies!=null) {%>
		<h3>당신의 취미는?</h3>
		<ul>
		<%for(String h : hobbies){ %>
			<li><%=h %></li>
		<%} %>
		</ul>
	<%} %>

<h2>jsp로 controller 기능하기</h2>
	<h3><a href="<%=request.getContextPath() %>/views/memberSearch.jsp">회원조회</a></h3>


<h2>지시자 page이용하기</h2>
<p>
	page 각종 jsp파일에 대하 설정을 하기 위한태그
	jsp파일의 맨위에 선언이 되어있어야함.
</p>
<h2>import속성</h2>
<p>
페이지에 다른 패키지에 있는 클래스를 이용하기 위해 사용</p>
<h3><a href="<%=request.getContextPath() %>/views/importTest.jsp">임포트하기</a></h3>

<h2>에러페이지 이동시키기</h2>
<p>
에러코드에 의한 에러(404,500....) 페이지 이동
exception에 의한 에러(500 에러)기준으로 페이지 이동 -> exception 타입으로 에러 나면 500이란 말
</p>
<p>
처리방법
1.web.xml태그를 이용하는방법
2.jsp지시자 태그 errorPage속성을 이용하는 방법.
</p>
<h3><a href="<%=request.getContextPath() %>/views/errorTest.jsp">에러발생</a></h3>
<%-- <%
String name=null;
name.length();
%> --%>
<h3><a href="slslsl.jsp">아무거나 연결하기</a></h3>


<h2>include지시자 이용하기</h2>
<p>다른 jsp 페이지를 가져오는 것==iframe 태그와 비슷</p>
<h3><a href="<%=request.getContextPath() %>/views/main.jsp">메인으로!</a></h3>

</body>
</html>