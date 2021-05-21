package com.board.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.board.model.dao.BoardDao;
import com.board.model.vo.Board;
import com.board.model.vo.Comment;

public class BoardService {
	private BoardDao dao=new BoardDao();

	public int selectBoardListCount() {
		  Connection conn=getConnection();
		  int result=dao.selectBoardListCount(conn);
			close(conn);
			return result;
		}
		
		
	
	public List<Board> selectBoardList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Board> list=dao.selectBoardList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	public Board selectBoard(int no,boolean readflag) {
		Connection conn=getConnection();
		Board b=dao.selectBoard(conn, no);
		if(b!=null&&!readflag) {
			int result=dao.updateReadCount(conn,no);
			if(result>0) {
				commit(conn);
				b.setBoardReadcount(b.getBoardReadcount()+1);
			}
			else rollback(conn);
		}
		close(conn);
		return b;
	}
	
	public int insertBoard(Board b) {
		Connection conn=getConnection();
		int result=dao.insertBoard(conn,b);
		 if(result>0)commit(conn);
		 else rollback(conn);
		 close(conn);
		 return result;
	}
	
	public int insertComment(Comment c) {
		Connection conn=getConnection();
		int result=dao.insertComment(conn,c);
		 if(result>0)commit(conn); 
		else rollback(conn);
		 close(conn);
		 return result;
	}
	
	public List<Comment> selectComment(int no){
		Connection conn=getConnection();
		List<Comment> list=dao.selectComment(conn,no);
		close(conn);
		return list;
	}
	
}
