package com.example.bowling.vo;

public class Board {
	private int boardNo;
	private String boardCategory;
	private String boardTitle;
	private String boardFirstDate;
	private String boardLastDate;
	private String boardUser;
	private String boardContent;
	
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle; 
	}
	public String getBoardFirstDate() {
		return boardFirstDate;
	}
	public void setBoardFirstDate(String boardFirstDate) {
		this.boardFirstDate = boardFirstDate;
	}
	public String getBoardLastDate() {
		return boardLastDate;
	}
	public void setBoardLastDate(String boardLastDate) {
		this.boardLastDate = boardLastDate;
	}
	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardCategory=" + boardCategory + ", boardTitle=" + boardTitle
				+ ", boardFirstDate=" + boardFirstDate + ", boardLastDate=" + boardLastDate + ", boardUser=" + boardUser
				+ ", boardContent=" + boardContent + "]";
	}
	

}
