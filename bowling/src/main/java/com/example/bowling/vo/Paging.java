package com.example.bowling.vo;

import lombok.Data;


public class Paging {
	private int beginRow;
	private int rowPerPage;
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	@Override
	public String toString() {
		return "Paging [beginRow=" + beginRow + ", rowPerPage=" + rowPerPage + "]";
	}
	
}
