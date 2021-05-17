package com.notice.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.member.model.vo.Member;
import com.notice.model.vo.notice;

public class noticeDao {
	private Properties prop=new Properties();
	public noticeDao() {
		String path=noticeDao.class.getResource("/sql/notice_sql.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<notice> selectNoticeList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<notice> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectnoticeList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				notice n=new notice();
				n.setNoticeNo(rs.getInt("notice_no"));
				n.setNoticeTitle(rs.getString("notice_title"));
				n.setNoticeWriter(rs.getString("notice_writer"));
				n.setNoticeContent(rs.getString("notice_content"));
				n.setNoticeDate(rs.getDate("notice_date"));
				n.setFilePath(rs.getString("filepath"));
				
				list.add(n);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public int selectNoticeListCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectnoticeListCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);		
	}catch(Exception e) {
		e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}return result;
		
	}
	 public notice selectNotice(Connection conn, int no) {
		 PreparedStatement pstmt=null;
		ResultSet rs=null;
		notice n=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectNotice"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				 n=new notice();
				n.setNoticeNo(rs.getInt("notice_no"));
				n.setNoticeTitle(rs.getString("notice_title"));
				n.setNoticeWriter(rs.getString("notice_writer"));
				n.setNoticeContent(rs.getString("notice_content"));
				n.setNoticeDate(rs.getDate("notice_date"));
				n.setFilePath(rs.getString("filepath"));
			}
			}
				catch(Exception e) {
					e.printStackTrace();
					}finally {
						close(pstmt);
						close(rs);
					}return n;
					
				}
	
}
