package com.example.bowling.vo;

import lombok.Data;

@Data
public class PlayerRecord {
	// 개인기록을 입력하기 위한 VO
	private int rank;
	private int playerNo;
	private String playerName;
	private int strikeAvg;
	private int spareAvg;
	private int score;
	private String winRate;
	private int win;
	private int lose;
	private int draw;
	private int matchGame;
	private int scoreAvg;
	private String gender;
	private String column;
}
