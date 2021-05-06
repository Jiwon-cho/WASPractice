<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList,com.member.model.vo.Member"%>
    <!-- 이게 import 하는법이다. -->
<%!
	/* import java.util.ArrayList;
	import com.member.model.vo.Member; */
%>    
<%
//_jspService();==doGet/doPost 비슷
	ArrayList<Member> list=new ArrayList();
	list.add(new Member("admin","admin","관리자",100));
	list.add(new Member("user01","user01","유저일",200));
	list.add(new Member("user02","user02","유저이",300));
	list.add(new Member("user03","user03","유저삼",400));
	
	request.setAttribute("members",list);
	
	request.getRequestDispatcher("resultMember.jsp").forward(request,response);
	
	
%>







