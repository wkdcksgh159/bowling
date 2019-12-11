package com.example.bowling.vo;


public class TeamPlayerName {
	private String teamName;
	private int playerNo;
	private String playerName;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getPlayerNo() {
		return playerNo;
	}
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Override
	public String toString() {
		return "TeamPlayerName [teamName=" + teamName + ", playerNo=" + playerNo + ", playerName=" + playerName + "]";
	}
	
}
