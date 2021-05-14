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
	
	
	public String checkId(String s) {
		Connection conn=getConnection();
		
		String checkId=dao.checkId(conn,s);
		close(conn);

		return checkId;
		
		
	}
	
	public Member selectMemberId(String userId) {
		Connection conn=getConnection();
		Member m=dao.selectMemberId(conn,userId);
		close(conn);
		return m;
	}
	
	public int deleteMember(String userId) {
Connection conn=getConnection();
		
		int result=dao.deleteMember(conn,userId);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);

		return result;
		
		
	}
	
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result=dao.updateMember(conn,m);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);

		return result;
	}
	
}
