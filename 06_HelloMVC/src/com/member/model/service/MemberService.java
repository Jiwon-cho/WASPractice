package com.member.model.service;

import java.sql.Connection;
import java.util.List;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.rollback;
import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

public class MemberService {

	private MemberDao dao=new MemberDao();
	
	public Member login(String userId,String password){
		
		Connection conn=getConnection();
		
		Member m=dao.login(conn,userId,password);

		return m;
	}
	
	
	public int register(Member m) {
		Connection conn=getConnection();
		int check=dao.register(conn,m);
		if (check>0) commit(conn);
		else rollback(conn);
		close(conn);

		return check;
		
	}
	
	
	public int checkId(String s) {
		Connection conn=getConnection();
		
		int checkId=dao.checkId(conn,s);
		
		return checkId;
		
		
	}
}
