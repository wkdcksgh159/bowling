package com.example.bowling.vo;

import lombok.Data;

@Data
public class Schedule {
	private int gameNo;
	private String hteamName;
	private int hteamScore;
	private String ateamName;
	private int ateamScore;
	private String hteamResult;
	private String ateamResult;
	private String gameDate;
}
