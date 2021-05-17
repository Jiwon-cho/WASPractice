package com.notice.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.notice.model.dao.noticeDao;
import com.notice.model.vo.notice;
public class noticeService {
	private noticeDao dao=new noticeDao();
	
	public int selectNoticeListCount() {
	  Connection conn=getConnection();
	  int result=dao.selectNoticeListCount(conn);
		close(conn);
		return result;
	}
	
	
	public List<notice> selectNoticeList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<notice> list=dao.selectNoticeList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	public notice selectNotice(int no) {
		Connection conn=getConnection();
		  notice n=dao.selectNotice(conn,no);
		  close(conn);
		  return n;
		
	}
	}
