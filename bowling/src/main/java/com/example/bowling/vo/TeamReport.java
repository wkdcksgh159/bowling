package com.example.bowling.vo;

import lombok.Data;

@Data
public class TeamReport {
	private int totalGame;
	private int totalScore;
	private int avgScore;
	private int avgWin;
	private int win;
	private int lose;
	private int draw;
}