package com.admin.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.admin.model.dao.AdminDao;
import com.member.model.vo.Member;
public class AdminService {
	private AdminDao dao=new AdminDao();
	
	public List<Member> selectMemberList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	public int selectMemberCount() {
		Connection conn=getConnection();
		int result=dao.selectMemberCount(conn);
		close(conn);
		return result;
				
	}
	
	public List<Member> selectSearchMember(String type, String keyword){
		Connection conn=getConnection();
		List<Member> list=dao.selectSearchMember(conn,type,keyword);
		close(conn);
		return list;
	}
}
