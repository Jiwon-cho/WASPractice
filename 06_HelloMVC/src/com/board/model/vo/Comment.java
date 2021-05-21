package com.board.model.vo;

import java.util.Date;

public class Comment {
	
	private int boardCommentNo;
	private int level;
	private String boardCommentWriter;
	private String boardCommentContent;
	private int boardRef;
	private int boardCommentRef;
	private Date boardCommentDate;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int boardCommentNo, int level, String boardCommentWriter, String boardCommentContent, int boardRef,
			int boardCommentRef, Date boardCommentDate) {
		super();
		this.boardCommentNo = boardCommentNo;
		this.level = level;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentContent = boardCommentContent;
		this.boardRef = boardRef;
		this.boardCommentRef = boardCommentRef;
		this.boardCommentDate = boardCommentDate;
	}
	public int getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getBoardCommentWriter() {
		return boardCommentWriter;
	}
	public void setBoardCommentWriter(String boardCommentWriter) {
		this.boardCommentWriter = boardCommentWriter;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public int getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	public int getBoardCommentRef() {
		return boardCommentRef;
	}
	public void setBoardCommentRef(int boardCommentRef) {
		this.boardCommentRef = boardCommentRef;
	}
	public Date getBoardCommentDate() {
		return boardCommentDate;
	}
	public void setBoardCommentDate(Date boardCommentDate) {
		this.boardCommentDate = boardCommentDate;
	}
	@Override
	public String toString() {
		return "Comment [boardCommentNo=" + boardCommentNo + ", level=" + level + ", boardCommentWriter="
				+ boardCommentWriter + ", boardCommentContent=" + boardCommentContent + ", boardRef=" + boardRef
				+ ", boardCommentRef=" + boardCommentRef + ", boardCommentDate=" + boardCommentDate + "]";
	}
	
	

}
