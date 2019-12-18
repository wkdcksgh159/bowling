package com.example.bowling.vo;

public class BoardPage {
	private int beginRow;
	private int rowPerPage;
	private String searchWord;
	
	public int getbeginRow() {
		return beginRow;
	}
	public void setbeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	@Override
	public String toString() {
		return "BoardPage [beginRow=" + beginRow + ", rowPerPage=" + rowPerPage + ", searchWord=" + searchWord
				+ "]";
	}

}
