package com.example.bowling.vo;

import lombok.Data;

@Data
public class PlayerRecord {
	// 개인기록을 입력하기 위한 VO
	private int playerNo;
	private String playerName;
	private int strikeAvg;
	private int spareAvg;
	private int score;
	private int winRate;
	private int win;
	private int lose;
	private int draw;
	private int totalGame;
	private int scoreAvg;
	private String gender;
}
