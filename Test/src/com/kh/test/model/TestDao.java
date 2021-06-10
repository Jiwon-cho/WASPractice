package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDao {

	
	public List<Test> selectList(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Test> list=new ArrayList<Test>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.3:1521:xe","kh","kh");
			
			String sql="SELECT * FROM TEST";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Test t=new Test();
				t.setSeq(rs.getInt("SEQ"));
				t.setWriter(rs.getString("WRITER"));
				t.setTitle(rs.getString("TITLE"));
				t.setContent(rs.getString("CONTENT"));
				t.setRegdate(rs.getDate("REGDATE"));
				list.add(t);
			}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
