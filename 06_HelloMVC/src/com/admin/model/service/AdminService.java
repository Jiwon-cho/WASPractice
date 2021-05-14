package com.admin.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.admin.model.dao.AdminDao;
import com.member.model.vo.Member;
public class AdminService {
	private AdminDao dao=new AdminDao();
	
	public List<Member> selectMemberList(){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberList(conn);
		close(conn);
		return list;
	}
	
}
