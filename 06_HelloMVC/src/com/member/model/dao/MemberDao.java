package com.member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import com.member.model.vo.Member;
import static com.common.JDBCTemplate.close;


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
	
	public int register(Connection conn,Member m) {
		PreparedStatement pstmt=null;
		int result = 0;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insert"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9,m.getHobby());
			
			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int checkId(Connection conn,String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int check=0;
		try {
			
		}
	}
	
}
