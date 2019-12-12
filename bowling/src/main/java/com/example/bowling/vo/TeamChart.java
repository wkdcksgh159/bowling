package com.example.bowling.vo;


public class TeamChart {
	private String teamName;
	private String playerName;
	private double avgStrike;
	private String gameDate;
	private int winRate;
	private int pin1;
	private int pin2;
	private int pin3;
	private int pin4;
	private int pin5;
	private int pin6;
	private int pin7;
	private int pin8;
	private int pin9;
	private int pin10;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public double getAvgStrike() {
		return avgStrike;
	}
	public void setAvgStrike(double avgStrike) {
		this.avgStrike = avgStrike;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public int getWinRate() {
		return winRate;
	}
	public void setWinRate(int winRate) {
		this.winRate = winRate;
	}
	public int getPin1() {
		return pin1;
	}
	public void setPin1(int pin1) {
		this.pin1 = pin1;
	}
	public int getPin2() {
		return pin2;
	}
	public void setPin2(int pin2) {
		this.pin2 = pin2;
	}
	public int getPin3() {
		return pin3;
	}
	public void setPin3(int pin3) {
		this.pin3 = pin3;
	}
	public int getPin4() {
		return pin4;
	}
	public void setPin4(int pin4) {
		this.pin4 = pin4;
	}
	public int getPin5() {
		return pin5;
	}
	public void setPin5(int pin5) {
		this.pin5 = pin5;
	}
	public int getPin6() {
		return pin6;
	}
	public void setPin6(int pin6) {
		this.pin6 = pin6;
	}
	public int getPin7() {
		return pin7;
	}
	public void setPin7(int pin7) {
		this.pin7 = pin7;
	}
	public int getPin8() {
		return pin8;
	}
	public void setPin8(int pin8) {
		this.pin8 = pin8;
	}
	public int getPin9() {
		return pin9;
	}
	public void setPin9(int pin9) {
		this.pin9 = pin9;
	}
	public int getPin10() {
		return pin10;
	}
	public void setPin10(int pin10) {
		this.pin10 = pin10;
	}
	
	@Override
	public String toString() {
		return "TeamChart [teamName=" + teamName + ", playerName=" + playerName + ", avgStrike=" + avgStrike
				+ ", gameDate=" + gameDate + ", winRate=" + winRate + ", pin1=" + pin1 + ", pin2=" + pin2 + ", pin3="
				+ pin3 + ", pin4=" + pin4 + ", pin5=" + pin5 + ", pin6=" + pin6 + ", pin7=" + pin7 + ", pin8=" + pin8
				+ ", pin9=" + pin9 + ", pin10=" + pin10 + "]";
	}
}