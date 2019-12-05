package com.example.bowling.vo;

import lombok.Data;
// 경기 결과를 저장하는 객체
@Data
public class GameResult {
	private int gameNo;
	private String hteamName;
	private int hteamScore;
	private String hteamResult;
	private String ateamResult;
	private int ateamScore;
	private String ateamName;

}
