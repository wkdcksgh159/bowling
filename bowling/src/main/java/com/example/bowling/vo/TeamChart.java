package com.example.bowling.vo;


public class TeamChart {
	private String teamName;
	private String playerName;
	private double avgStrike;
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
	@Override
	public String toString() {
		return "TeamChart [teamName=" + teamName + ", playerName=" + playerName + ", avgStrike=" + avgStrike + "]";
	}
}