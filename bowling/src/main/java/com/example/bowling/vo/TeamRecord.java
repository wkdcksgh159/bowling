package com.example.bowling.vo;

import lombok.Data;

@Data
public class TeamRecord {
	private String teamName;
	private int rank;
	private int matchGame;
	private int scoreAvg;
	private int winAvg;
	private int win;
	private int lose;
	private int draw;
	private int strikeAvg;
	private String gender;
	private String column;
	private int totalScore;
}