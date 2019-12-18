package com.example.bowling.vo;

import lombok.Data;

@Data

public class GameResult {
	private int gameNo;
	private String hteamName;
	private int hplayerNo;
	private int hteamScore;
	private String hteamResult;
	private String ateamResult;
	private int ateamScore;
	private String ateamName;
	private int aplayerNo;
}
