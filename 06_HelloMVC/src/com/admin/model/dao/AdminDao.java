package com.admin.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;
import com.member.model.vo.Member;

public class AdminDao {

	private Properties prop=new Properties();

	/**
	 * @param prop
	 */
	public AdminDao() {
		String path=AdminDao.class.getResource("/sql/admin_sql.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> selectMemberList(Connection conn,int cPage,int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setUserId(rs.getString("userid"));
				m.setPassword(rs.getString("password"));
				m.setUserName(rs.getString("username"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setHobby(rs.getString("hobby"));
				m.setAddress(rs.getString("address"));
				m.setEnrollDate(rs.getDate("enrolldate"));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);		
	}catch(Exception e) {
		e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}return result;
		
	}
	
	
	public List<Member>selectSearchMember(Connection conn,int cPage,int numPerpage, String type, String keyword){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList<Member>();
		String sql=prop.getProperty("selectSearchMember");
		try {
			pstmt=conn.prepareStatement(sql.replace("#", type));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member m=new Member();
				m.setUserId(rs.getString("userId"));
				m.setUserName(rs.getString("username"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enrolldate"));
				list.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	
	public int selectSearchMemberCount(Connection conn, String type, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String sql=prop.getProperty("selectSearchMemberCount");
		try {
			pstmt=conn.prepareStatement(sql.replace("#", type));
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);		
	}catch(Exception e) {
		e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}return result;
		
	}
	
}
