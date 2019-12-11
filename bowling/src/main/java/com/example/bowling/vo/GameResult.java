package com.example.bowling.vo;


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
	public int getHplayerNo() {
		return hplayerNo;
	}
	public void setHplayerNo(int hplayerNo) {
		this.hplayerNo = hplayerNo;
	}
	public int getHteamScore() {
		return hteamScore;
	}
	public void setHteamScore(int hteamScore) {
		this.hteamScore = hteamScore;
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
	public int getAteamScore() {
		return ateamScore;
	}
	public void setAteamScore(int ateamScore) {
		this.ateamScore = ateamScore;
	}
	public String getAteamName() {
		return ateamName;
	}
	public void setAteamName(String ateamName) {
		this.ateamName = ateamName;
	}
	public int getAplayerNo() {
		return aplayerNo;
	}
	public void setAplayerNo(int aplayerNo) {
		this.aplayerNo = aplayerNo;
	}
	@Override
	public String toString() {
		return "GameResult [gameNo=" + gameNo + ", hteamName=" + hteamName + ", hplayerNo=" + hplayerNo
				+ ", hteamScore=" + hteamScore + ", hteamResult=" + hteamResult + ", ateamResult=" + ateamResult
				+ ", ateamScore=" + ateamScore + ", ateamName=" + ateamName + ", aplayerNo=" + aplayerNo + "]";
	}

}
