package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.notice.model.service.noticeService;
import com.notice.model.vo.notice;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class NoticeWrtierEndServlet
 */
@WebServlet("/notice/noticeWriteEnd")
public class NoticeWrtierEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWrtierEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//파일 업로드 로직을 처리하기
		//파일 업로드 시에는 cos.jar 에서 제공하는 클래스를 이용함.
		//MultipartRequest클래스를 생성해서 이용함. -> 파일 업로드를 해줌. //binary 파일/ 식으로 안오면 이걸로 하면안됨
		
		//enctype 체킹 하기 -> multipart/form-data로 넘어오는가?
		if(!ServletFileUpload.isMultipartContent(request)) {
			//잘못된 요청으로 에러처리함.
			request.setAttribute("msg", "공지사항작성오류[form:enctype]관련");
			request.setAttribute("loc", "/notice/noticeList");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
			//이게 되더라도 밑에껄 읽기 때문에 다시 돌아가게 해서 안읽게함
			
		}
		
		//파일 업로드는 cos.jar에서 제공하는 MultipartRequest클래스를 생성해서 구현을 함.
		//MultipartRequest 클래스를 생성할 때 매개변수가 있는 생성자를 이용
		//1. HttpServletRequest / 2. 업로드된 파일을 저장할 경로/ 3. 파일의 최대크기
		//4. 파일에 대한 인코딩 값/ 5. 업로드파일명 리네임 로직(객체)
		
		//파일 업로드경로는 HDD 에 있는 경로는 직접경로로 가져와야함.
		//ServletContext객체의 getRealPath() 매소드를 이용하면 contextroot 의 경로를 가져옴
		
//		String path=getServletContext().getRealPath("/"); contextrood -> web
		String path=getServletContext().getRealPath("/upload/notice/");
		System.out.println(path);
		//2.파일 사이즈 설정 -> 최대 용량
		int maxSize=1024*1024*10;//10mb 
		//3. 파일 인코딩 값
		String encode="UTF-8";
		//4. rename 클래스 DefaultFileRenamePolicy 클래스 이용
		FileRenamePolicy policy=new DefaultFileRenamePolicy();
		//커스터마이징 가능
		
		MultipartRequest mr=new MultipartRequest(request,path,maxSize,encode,policy);
		
		//MultipartRequest객체를 생성하면 그 객체로 파라미터 값을 받아올 수 있다.
		//MultipartRequest객체로 쏘면 그걸로 가져옴
		notice n=new notice();
		n.setNoticeTitle(mr.getParameter("noticeTitle"));
		n.setNoticeWriter(mr.getParameter("noticeWriter"));
		n.setNoticeContent(mr.getParameter("content"));
		
		//DB에는 리네임된 파일명을 저장
		//리네임된 파일명은 MultipartRequest객체의 getFilesystemName("up_file");
		n.setFilePath(mr.getFilesystemName("up_file"));//file 을 올리는 곳의 파라미터명
//		System.out.println(mr.getOriginalFileName("up_file"));
//		System.out.println(n);
		
	int result=new noticeService().insertNotice(n);
	String msg="";
	String loc="";
	if(result>0) {
		msg="등록에 성공하였습니다.";
		loc="/notice/noticeList";
	}else {
		msg="등록에 실패하였습니다.";
		loc="/notice/noticeWrite";
	}
	request.setAttribute("msg", msg);
	request.setAttribute("loc", loc);
	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
