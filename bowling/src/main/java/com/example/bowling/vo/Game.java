package com.example.bowling.vo;


public class Game {
	private int gameNo;
	private String hteamName;
	private int hplayerNo;
	private String ateamName;
	private int aplayerNo;
	private String stadiumName;
	private String gameDate;
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
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	@Override
	public String toString() {
		return "Game [gameNo=" + gameNo + ", hteamName=" + hteamName + ", hplayerNo=" + hplayerNo + ", ateamName="
				+ ateamName + ", aplayerNo=" + aplayerNo + ", stadiumName=" + stadiumName + ", gameDate=" + gameDate
				+ "]";
	}
}
