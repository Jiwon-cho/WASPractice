package com.member.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	
	public String checkId(Connection conn,String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String check=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("check"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				check="있다";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
	public Member selectMemberId(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberId"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setUserId(rs.getString("userId"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("userName"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enrolldate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	
	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMember"));
//			pstmt.setString(1, m.getPassword());
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getGender());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7,m.getHobby());
			pstmt.setString(8, m.getUserId());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updatePassword(Connection conn,String userId, String pw) {
		PreparedStatement pstmt=null;;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updatePassword"));
			pstmt.setString(1, pw);
			pstmt.setString(2, userId);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
