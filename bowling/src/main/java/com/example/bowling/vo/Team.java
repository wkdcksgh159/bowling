package com.example.bowling.vo;


public class Team {
	private String teamName;
	private String stadiumName;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", stadiumName=" + stadiumName + "]";
	}
	
}
