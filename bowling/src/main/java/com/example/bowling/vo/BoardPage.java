package com.example.bowling.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class BoardPage {
	private int beginRow;
	private int rowPerPage;
	private String searchWord;
}
