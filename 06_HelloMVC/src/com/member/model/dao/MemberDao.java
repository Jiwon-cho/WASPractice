package com.member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


import com.member.model.vo.Member;

public class MemberDao {
	private Properties prop=new Properties();
	
	public MemberDao() {
	try {	
		String path=MemberDao.class.getResource("/sql/member_sql.properties").getPath();
		prop.load(new FileReader(path));
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public Member login(Connection conn, String userId, String password) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("select"));
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
		if(rs.next()) {
			m=new Member();
			m.setUserId(rs.getString("userid"));
			m.setPassword(rs.getString("password"));
			m.setUserName(rs.getString("username"));
			m.setGender(rs.getString("gender"));
			m.setAge(rs.getInt("age"));
			m.setEmail(rs.getString("email"));
			m.setPhone(rs.getString("phone"));
			m.setHobby(rs.getString("hobby"));
			m.setEnrollDate(rs.getDate("enrolldate"));
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
}
