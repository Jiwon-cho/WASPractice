package com.board.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.board.model.vo.Board;
import com.board.model.vo.Comment;
import com.notice.model.dao.noticeDao;

public class BoardDao {
	private Properties prop=new Properties();
	public BoardDao() {
		String path=noticeDao.class.getResource("/sql/board_sql.properties").getPath();
		try {
			prop.load(new FileReader(path));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int selectBoardListCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectboardListCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);		
	}catch(Exception e) {
		e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}return result;
		
	}
	
	
	public List<Board> selectBoardList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectboardList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b=new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardDate(rs.getDate("board_date"));
				b.setBoardRenamedFilename(rs.getString("board_renamed_filename"));
				b.setBoardOriginalFilename(rs.getString("board_original_filename"));
				b.setBoardReadcount(rs.getInt("board_readcount"));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public Board selectBoard(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board b=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectboard"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				b=new Board();
				b.setBoardNo(rs.getInt("board_no"));
				b.setBoardTitle(rs.getString("board_title"));
				b.setBoardWriter(rs.getString("board_writer"));
				b.setBoardContent(rs.getString("board_content"));
				b.setBoardRenamedFilename(rs.getString("board_renamed_filename"));
				b.setBoardOriginalFilename(rs.getString("board_original_filename"));

				b.setBoardReadcount(rs.getInt("board_readcount"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return b;
	}
	
	public int updateReadCount(Connection conn, int no) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateReadCount"));
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		return result;
	}
	
	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertBoard"));
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getBoardOriginalFilename());
			pstmt.setString(5, b.getBoardRenamedFilename());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	
	}
	
	public int insertComment(Connection conn, Comment c) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertComment"));
			pstmt.setInt(1, c.getLevel());
			pstmt.setString(2, c.getBoardCommentWriter());
			pstmt.setString(3, c.getBoardCommentContent());
			pstmt.setInt(4, c.getBoardRef()); 
//			pstmt.setInt(5, c.getBoardCommentRef());
			pstmt.setString(5,c.getBoardCommentRef()==0?null:String.valueOf(c.getBoardCommentRef()));
			//찹조가 없는 댓글은 null 이되야함
				
			result=pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}return result;
	
	}
	
	public List<Comment> selectComment(Connection conn, int no){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Comment> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectComment"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Comment c=new Comment();
				c.setBoardCommentNo(rs.getInt("board_comment_no"));
				c.setLevel(rs.getInt("board_comment_level"));
				c.setBoardCommentWriter(rs.getString("board_comment_writer"));
				c.setBoardCommentContent(rs.getString("board_comment_content"));
				c.setBoardRef(rs.getInt("board_ref"));
				c.setBoardCommentRef(rs.getInt("board_comment_ref"));
				c.setBoardCommentDate(rs.getDate("board_comment_date"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public int updateBoard(Connection conn, int bld, String title, String content) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="UPDATE BOARD SET BTITLE= ?,BCONTENT=? WHERE BLD= ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bld);
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}	
