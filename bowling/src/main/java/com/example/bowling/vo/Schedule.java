package com.example.bowling.vo;

public class Schedule {
	private int gameNo;
	private String hteamName;
	private int hteamScore;
	private String ateamName;
	private int ateamScore;
	private String hteamResult;
	private String ateamResult;
	private String gameDate;
	@Override
	public String toString() {
		return "Schedule [gameNo=" + gameNo + ", hteamName=" + hteamName + ", hteamScore=" + hteamScore + ", ateamName="
				+ ateamName + ", ateamScore=" + ateamScore + ", hteamResult=" + hteamResult + ", ateamResult="
				+ ateamResult + ", gameDate=" + gameDate + "]";
	}
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	public String getHteamName() {
		return hteamName;
	}
	public void setHteamName(String hteamName) {
		this.hteamName = hteamName;
	}
	public int getHteamScore() {
		return hteamScore;
	}
	public void setHteamScore(int hteamScore) {
		this.hteamScore = hteamScore;
	}
	public String getAteamName() {
		return ateamName;
	}
	public void setAteamName(String ateamName) {
		this.ateamName = ateamName;
	}
	public int getAteamScore() {
		return ateamScore;
	}
	public void setAteamScore(int ateamScore) {
		this.ateamScore = ateamScore;
	}
	public String getHteamResult() {
		return hteamResult;
	}
	public void setHteamResult(String hteamResult) {
		this.hteamResult = hteamResult;
	}
	public String getAteamResult() {
		return ateamResult;
	}
	public void setAteamResult(String ateamResult) {
		this.ateamResult = ateamResult;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	
	
}
